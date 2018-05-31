package com.netpet.spools.spring.ioc.utils;

public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class loadClass(String className) {
        try {
            return getDefaultClassLoader().loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
