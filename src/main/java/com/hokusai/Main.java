package com.hokusai;

import org.graalvm.polyglot.*;
import org.graalvm.polyglot.io.*;

import java.io.File;
import java.nio.file.StandardCopyOption;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import org.apache.commons.io.IOUtils;

import net.java.dev.jna.Library;
import net.java.dev.jna.Native;

interface CLibrary extends Library {
    public int chmod(String path, int mode);
}

public class Main {
  private static CLibrary libc = (CLibrary) Native.loadLibrary("c", CLibrary.class);

  public static void main(String[] args) {
    try {
      InputStream input = Thread.currentThread()
        .getContextClassLoader()
        .getResourceAsStream("ruby.zip");

      String tmpDir = "."; //System.getProperty("java.io.tmpdir"); 
      File targetFile = new File("ruby.moved.zip");
      Path targetPath = Paths.get(tmpDir, targetFile.toPath().toString());

      Files.copy(
        input,
        targetPath,
        StandardCopyOption.REPLACE_EXISTING
      );

      libc.chmod(targetPath.toString(), 0755);

      IOUtils.closeQuietly(input);

      java.nio.file.FileSystem nioFs = FileSystems.newFileSystem(targetPath);

      IOAccess io = IOAccess.newBuilder()
        .fileSystem(FileSystem.newFileSystem(nioFs))
        .build();

      Context polyglot = Context.newBuilder("ruby")
        .allowIO(io)
        .allowAllAccess(true)
        .allowNativeAccess(true)
        .build();
      String name = polyglot.eval("ruby", "require 'hokusai'").asString();

      System.out.println("Hello World " + "I mean " + name);
    } catch(IOException e) {
      System.out.println(e.toString());
    }
  }
}