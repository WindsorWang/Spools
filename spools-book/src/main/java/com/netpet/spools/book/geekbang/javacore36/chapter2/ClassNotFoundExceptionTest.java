/*
 * Copyright (C) 2014-2020 Nuhtech Technology(Beijing) Co.,Ltd.
 *
 * All right reserved.
 *
 * This software is the confidential and proprietary
 * information of Nuhtech Company of China.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with Nuhtech inc.
 *
 */

package com.netpet.spools.book.geekbang.javacore36.chapter2;

/**
 * @author admin
 * @date 2018/5/25
 */
public class ClassNotFoundExceptionTest {

    public static void main(String[] args) throws Exception {
        // 1. Class.forName()
        Class.forName("com.netpet.spools.book.geekbang.javacore36.chapter2.ReferClass");
        Class.forName("com.netpet.spools.book.geekbang.javacore36.chapter2.ReferClass1");

        // 2. ClassLoader.loadClass()
        ClassLoader.getSystemClassLoader().loadClass("com.netpet.spools.book.geekbang.javacore36.chapter2.ReferClass");
        ClassLoader.getSystemClassLoader().loadClass("com.netpet.spools.book.geekbang.javacore36.chapter2.ReferClass2");

        // 3. ClassLoader.findSystemClass()
        MyClassLoader myClassLoader = new MyClassLoader();
    }
}

class MyClassLoader extends ClassLoader {

    public MyClassLoader() throws Exception {

            super.findSystemClass("com.netpet.spools.book.geekbang.javacore36.chapter2.ReferClass");
            super.findSystemClass("com.netpet.spools.book.geekbang.javacore36.chapter2.ReferClass3");

    }

}
