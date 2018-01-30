package com.netpet.spools.spring.ioc.core;

public interface BeanFactory {

    Object getBean(String name) throws Exception;

}
