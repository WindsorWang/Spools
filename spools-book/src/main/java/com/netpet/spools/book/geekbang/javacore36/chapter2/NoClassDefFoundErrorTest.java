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
 * 编译成功后直接删除.class文件，然后run，就会报错NoClassDefFoundError
 *
 * @author admin
 * @date 2018/5/25
 */
public class NoClassDefFoundErrorTest {

    public static void main(String[] args) {

        // 1. new
        ReferClass rc = new ReferClass();

        // 2. method call
        ReferClass.test();
    }
}

class ReferClass {

    public static void test() {}

}
