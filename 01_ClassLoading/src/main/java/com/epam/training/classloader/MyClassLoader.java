package com.epam.training.classloader;

import org.apache.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by Vasyl_Melnychuk on 10/1/2014.
 */
public class MyClassLoader extends ClassLoader {
    static final Logger logger = Logger.getLogger(MyClassLoader.class);
    private static final String DEFAULT_JAR_DIR = "d:/jars/";
    private static final String DEFAULT_JAR_FILE = "Dog.jar";
    private String jarFileName;
    private static String jarDir;
    private Map<String, Class<?>> classCache = new HashMap<String, Class<?>>();

    public MyClassLoader() {
        super(MyClassLoader.class.getClassLoader());
        this.jarDir = DEFAULT_JAR_DIR;
        this.jarFileName = DEFAULT_JAR_FILE;
    }

    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String className) throws ClassNotFoundException {
        return findClass(className);
    }

    public static String getJarDir() {
        return jarDir;
    }

    public static void setJarDir(String jarDir) {
        MyClassLoader.jarDir = jarDir;
    }

    public String getJarFileName() {
        return jarFileName;
    }

    public void setJarFileName(String jarFileName) {
        this.jarFileName = jarFileName;
    }

    @Override
    public String toString() {
        return MyClassLoader.class.getName();
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        //check the class cache
        if(classCache.containsKey(className)) {
            //log class found in cache
            logger.info("% Class " + className + " found in cache");
            return classCache.get(className);
        }

        //check for system class
        try {
            return findSystemClass(className);
        } catch (ClassNotFoundException e) {
            //log the not system class
            logger.info("% Class " + className + " is not system class");
        }

        //load class form jar
        byte classData[];
        Class result = null;
        try {
            classData = loadClassData(className);
        } catch (IOException e) {
            logger.error("% Class " + className + " not found");
            throw new ClassNotFoundException( "Class [" + className + "] ", e );
        }
        result = defineClass(className, classData, 0, classData.length, null);
        logger.info("% Class " + className + " cached");
        classCache.put(className, result);
        return result;
    }

    private byte[] loadClassData(String className) throws IOException {
        byte[] classData;
        JarFile jar = new JarFile(jarDir + jarFileName);
        JarEntry entry  = jar.getJarEntry(className + ".class");
        InputStream is = jar.getInputStream(entry);
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int nextValue = is.read();
        while (-1 != nextValue) {
            byteStream.write(nextValue);
            nextValue = is.read();
        }
        classData = byteStream.toByteArray();
        return classData;
    }


}
