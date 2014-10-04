package com.epam.training.classloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/**
 * Created by Vasyl_Melnychuk on 10/2/2014.
 */
public class MyClassLoaderTesting {
    private MyClassLoader loader;
    private Class Feature1;
    private Class Feature2;
    private String jarsDir;

    public MyClassLoaderTesting(String jarsDir) throws ClassNotFoundException {
        this.jarsDir = jarsDir;
        this.loader = new MyClassLoader();
        this.loader.setJarDir(jarsDir);
        this.loader.setJarFileName("Feature1.jar");
        this.Feature1 = loader.loadClass("Feature1");
//        this.Feature1 = Class.forName("Feature1", true, loader);
        this.loader.setJarFileName("Feature2.jar");
        this.Feature2 = loader.loadClass("Feature2");
    }
    public enum Action {
        EXECUTE_F1, EXECUTE_F2, RELOAD_F1, RELOAD_F2, EXIT
    }
    public void drawMenu() {
        System.out.println("Actions:");
        System.out.println("1. Execute Feature 1");
        System.out.println("2. Execute Feature 2");
        System.out.println("3. Reload Feature 1");
        System.out.println("4. Reload Feature 2");
        System.out.println("5. Exit");
        System.out.print("Make your choice : 5: ");
    }
    public Action readAction() throws IOException {
        String actionString;
        int actionNumber;
        Action action;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        actionString = br.readLine();
        actionNumber = parseIntWithDefault(actionString, 0);
        switch (actionNumber) {
            case 1:
                action = Action.EXECUTE_F1;
                break;
            case 2:
                action = Action.EXECUTE_F2;
                break;
            case 3:
                action = Action.RELOAD_F1;
                break;
            case 4:
                action = Action.RELOAD_F2;
                break;
            default:
                action = Action.EXIT;
                break;
        }
        return action;
    }
    public void reloadFeature(String featureName) throws ClassNotFoundException {
        loader = new MyClassLoader();
        loader.setJarDir(jarsDir);
        loader.setJarFileName(featureName + ".jar");
        this.Feature1 = loader.loadClass(featureName);
    }
    public void executeFeature(String featureName) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object feature = null;
        switch (featureName) {
            case "Feature1":
                feature = Feature1.newInstance();
                Feature1.getMethod("execute").invoke(feature);
                break;
            case "Feature2":
                feature = Feature2.newInstance();
                Feature2.getMethod("execute").invoke(feature);
                break;
        }
    }
    private int parseIntWithDefault(String number, int defaultValue) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    public static void main(String[] args) throws Exception {
        MyClassLoaderTesting loaderTest = new MyClassLoaderTesting("d:/jars/");
        run: while(true) {
            Action userAction;
            loaderTest.drawMenu();
            userAction = loaderTest.readAction();
            switch (userAction) {
                case EXECUTE_F1:
                    loaderTest.executeFeature("Feature1");
                    break;
                case EXECUTE_F2:
                    loaderTest.executeFeature("Feature2");
                    break;
                case RELOAD_F1:
                    loaderTest.reloadFeature("Feature1");
                    break;
                case RELOAD_F2:
                    loaderTest.reloadFeature("Feature2");
                    break;
                case EXIT:
                    break run;
            }
        }
//        loaderTest.executeFeature("Feature1");
//        loaderTest.executeFeature("Feature2");
//        loaderTest.reloadFeature("Feature1");
//        loaderTest.executeFeature("Feature1");

//
//        ClassLoader loader = new MyClassLoader();
//        Class clazz = Class.forName("Dog", true, loader);
//        Object object = clazz.newInstance();
//        clazz.getMethod("bark").invoke(object);
    }
}
