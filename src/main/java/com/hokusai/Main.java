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

import java.util.function.Consumer;
import java.util.function.IntConsumer;

import com.hokusai.commands.*;
import com.hokusai.ZipUtils;

import com.hokusai.Backend;
import java.util.function.Consumer;


public class Main {
  public static void main(String[] args) {
    try 
    {

      InputStream input = Thread.currentThread()
        .getContextClassLoader()
        .getResourceAsStream("ruby.zip");
     
      System.out.println("Unpacking ruby");
      
      String tmpDir = System.getProperty("java.io.tmpdir"); 
      File targetFile = new File("ruby.moved.zip");
      Path targetPath = Paths.get(tmpDir, "truffleruby");
      ZipUtils.unzip(input, new File(tmpDir));
      
      System.out.println("Done");

      Runtime.getRuntime().exec("chmod 775 " + targetPath.toString());

      input.close();
      System.setProperty("ruby.home", targetPath.toString());
      System.setProperty("org.graalvm.language.ruby.home", targetPath.toString());
      Context polyglot = Context.newBuilder("ruby")
        .allowAllAccess(true)
        .allowNativeAccess(true)
        .build();

      Backend backend = new Backend(polyglot);
      polyglot.eval("ruby", "require \"hokusai\"");
      backend.setOnDrawCircle((Consumer<CircleCommandWrapper>) command -> System.out.println("Draw circle: " + command.radius()));
      backend.setOnDrawRect((Consumer<RectCommandWrapper>) command -> System.out.println(String.format("Draw rect: [%f, %f, %f, %f]", command.x(), command.y(), command.width(), command.height())));
      backend.setupHokusaiCallbacks();

      String app = """
      class App < Hokusai::Block
        template <<~EOF
        [template]
          vblock
            vblock { :height="100.0" }
              circle { :radius="43.0" }
            vblock
              circle { :radius="20.0"}
            
        EOF

        uses(vblock: Hokusai::Blocks::Vblock, circle: Hokusai::Blocks::Circle)
      end

      App
      """;

      backend.run(app);
    } catch(Exception e) {
      System.out.println(e.toString());
    }
  }
}