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
