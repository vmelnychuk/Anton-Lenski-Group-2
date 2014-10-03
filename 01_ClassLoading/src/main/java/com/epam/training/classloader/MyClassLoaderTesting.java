package com.epam.training.classloader;

/**
 * Created by Vasyl_Melnychuk on 10/2/2014.
 */
public class MyClassLoaderTesting {
    public static void main(String[] args) throws Exception {
        ClassLoader loader = new MyClassLoader();
        Class clazz = Class.forName("Dog", true, loader);
        Object object = clazz.newInstance();
        clazz.getMethod("bark").invoke(object);
    }
}
