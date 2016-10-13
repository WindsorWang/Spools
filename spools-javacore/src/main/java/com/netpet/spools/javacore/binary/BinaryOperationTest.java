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

package com.netpet.spools.javacore.binary;

/**
 * Created by woncz on 2016/10/13.
 */
public class BinaryOperationTest {

    public static void main(String[] args) {
        int a = 1 << 30;
        int b = Integer.MAX_VALUE;

        System.out.println("a = " + a + ", b = " + b + ", b-a = " + (b - a));
    }
}
