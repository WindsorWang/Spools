/*
 * Copyright (C) 2014-2016 Beijing BaoJiaBei Technology Co.,Ltd.
 * 
 * All right reserved.
 * 
 * This software is the confidential and proprietary
 * information of BaoJiaBei Company of China. 
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement 
 * you entered into with BaoJiaBei inc.
 *
 */

package com.netpet.spools.javacore.basicdatatype;

/**
 * Created by woncz on 2016/8/11.
 */
public class Char {

    public static void main(String[] args) {
        String ts = "ab";

        char[] a = ts.toCharArray();

        System.out.print((0 + a[0]) + " ");
        System.out.print("\n");

        System.out.println("Byte : " + Byte.MAX_VALUE);
        System.out.println("Byte : " + Byte.MIN_VALUE);
        System.out.println("Short : " + Short.MAX_VALUE);
        System.out.println("Short : " + Short.MIN_VALUE);
        System.out.println("Integer : " + Integer.MAX_VALUE);
        System.out.println("Integer : " + Integer.MIN_VALUE);
        System.out.println("Long : " + Long.MAX_VALUE);
        System.out.println("Long : " + Long.MIN_VALUE);
    }
}
