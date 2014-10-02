package com.epam.training.classloader;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by Vasyl_Melnychuk on 10/1/2014.
 */
public class MyClassLoader extends ClassLoader {
    private static final String JAR_DIR = "d:/jars/Dog.jar";
    private Map<String, Class<?>> classCache = new HashMap<String, Class<?>>();

    public MyClassLoader() {
        super(MyClassLoader.class.getClassLoader());
    }

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String className) throws ClassNotFoundException {
        return findClass(className);
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        byte classByte[];
        Class result = null;

        result = (Class) classCache.get(className); // check cache
        if (result != null) {
            return result;
        }

        try {
            return findSystemClass(className);
        } catch (Exception e) {
        }

        try {
            JarFile jar = new JarFile(JAR_DIR);
            JarEntry entry  = jar.getJarEntry(className + ".class");
            InputStream is = jar.getInputStream(entry);
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            int nextValue = is.read();
            while (-1 != nextValue) {
                byteStream.write(nextValue);
                nextValue = is.read();
            }
            classByte = byteStream.toByteArray();
            result = defineClass(className, classByte, 0, classByte.length, null);
            classCache.put(className, result);
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return MyClassLoader.class.getName();
    }


}
