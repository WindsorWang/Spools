package com.netpet.spools.spring.ioc.utils;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

public class BeanUtils {

    public static <T> T instanceByCglib(Class<T> clz, Constructor ctr, Object[] args) {
        // 应该用原生的cglib，此处直接使用spring的代理
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clz);
        enhancer.setCallback(NoOp.INSTANCE);

        if (ctr == null) {
            return (T) enhancer.create();
        } else {
            return (T) enhancer.create(ctr.getParameterTypes(), args);
        }
    }
}
