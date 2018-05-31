package com.netpet.spools.spring.ioc.utils;

import java.lang.reflect.Field;

public class ReflectionUtils {

    public static void injectField(Field field, Object obj, Object value) throws IllegalAccessException {
        if (field != null) {
            field.setAccessible(true);
            field.set(obj, value);
        }
    }

}
