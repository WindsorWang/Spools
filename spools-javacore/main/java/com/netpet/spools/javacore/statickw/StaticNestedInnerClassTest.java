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

package com.netpet.spools.javacore.statickw;

/**
 * Created by woncz on 2016/8/10.
 */
public class StaticNestedInnerClassTest {

    public static void main(String[] args) {
        // 静态嵌套类 实例化
        StaticNestedInnerClass.StaticNested staticNested = new StaticNestedInnerClass.StaticNested();

        // 内部类 实例化
        StaticNestedInnerClass.Inner inner = new StaticNestedInnerClass().new Inner();
    }
}
