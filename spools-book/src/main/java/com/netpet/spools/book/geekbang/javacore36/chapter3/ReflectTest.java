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

import java.lang.reflect.Field;

/**
 * @author admin
 * @date 2018/5/28
 */
public class ReflectTest {

    public static void main(String[] args) {
        try {
            Util1 u1 = new Util1();
            Field field = u1.getClass().getDeclaredField("a");
            field.setAccessible(true);
            field.set(u1,789);
            System.out.println(field.get(u1));
            System.out.println(u1.a);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        try {
            Util2 u2 = new Util2();
            Field field = u2.getClass().getDeclaredField("a");
            field.setAccessible(true);
            field.set(u2,789);
            System.out.println(field.get(u2));
            System.out.println(u2.a); // 基本数据类型会被看成常量，所以值不会被修改
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}

class Util1 {

    public final Integer a = 65535;
}

class Util2 {
    public final int a = 65535;
}