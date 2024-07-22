package com.roc.classLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {
    private final String classDir;

    public MyClassLoader(String classDir) {
        this.classDir = classDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classFile = classDir + "/" + name.replace(".", "/") + ".class";
        System.out.println("自定义的类加载器---> " + name);
        try {
            byte[] classBytes = Files.readAllBytes(Paths.get(classFile));
            return defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
