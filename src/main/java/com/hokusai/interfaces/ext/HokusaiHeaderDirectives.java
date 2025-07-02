package com.hokusai.interfaces.ext;

import org.graalvm.nativeimage.c.CContext;
import java.util.List;
import java.util.Arrays;
import java.io.File;

final class HokusaiHeaderDirectives implements CContext.Directives {
    @Override
    public List<String> getOptions() {
        File[] jnis = findJNIHeaders();
        return Arrays.asList("-I" + jnis[0].getParent());
    }

    @Override
    public List<String> getHeaderFiles() {
        File[] jnis = findJNIHeaders();
        return Arrays.asList("<" + jnis[0] + ">");
    }

    private static File[] findJNIHeaders() throws IllegalStateException {
        final File hokusaiHome = new File(System.getProperty("hokusai.ext"));

        System.out.println(hokusaiHome);
        final File[] jnis = {
            hokusaiHome
        };
        return jnis;
    }
}