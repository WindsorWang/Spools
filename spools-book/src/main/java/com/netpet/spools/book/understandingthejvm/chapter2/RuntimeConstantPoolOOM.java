package com.netpet.spools.book.understandingthejvm.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * Created by woncz on 2017/8/9.
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        test();
        // test1();
        test2();
    }

    static void test() {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str11 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str11.intern() == str11);
        System.out.println(str1 == str11);
        System.out.println(str1 == str11.intern());
        System.out.println(str1.intern() == str1);
        System.out.println(str1.intern() == str11.intern());

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }

    static void test1() {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

    /**
     * 测试数组与普通对象的打印结果
     */
    static void test2() {
        //对象：com.netpet.spools.book.understandingthejvm.chapter2.RuntimeConstantPoolOOM@1d56ce6a
        RuntimeConstantPoolOOM oom = new RuntimeConstantPoolOOM();
        System.out.println(oom);

        //二维数组：[[Lcom.netpet.spools.book.understandingthejvm.chapter2.RuntimeConstantPoolOOM;@5197848c
        RuntimeConstantPoolOOM[][] ooms = new RuntimeConstantPoolOOM[10][10];
        System.out.println(ooms);
    }
}
