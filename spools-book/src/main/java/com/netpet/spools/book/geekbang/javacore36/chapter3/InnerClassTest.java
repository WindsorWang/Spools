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

package com.netpet.spools.book.geekbang.javacore36.chapter3;

/**
 * @author admin
 * @date 2018/5/28
 */
public class InnerClassTest {

    private final String var = "123";

    private String ts = "456";

    /**
     * 普通内部类对外部对象具有强引用
     */
    public class InnerClass1 {
        public InnerClass1() {
            System.out.println(var);
            ts = "Hello";
        }
    }

    /**
     * 静态内部类则没有，无法直接访问外部类的属性
     */
    public static class InnerClass2 {
        public InnerClass2() {
            //System.out.println(var);
        }
    }
}
