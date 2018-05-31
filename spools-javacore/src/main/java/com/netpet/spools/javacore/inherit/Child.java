package com.netpet.spools.javacore.inherit;

public class Child extends Parent {

    public Child() {
        // 会自动调用父类的构造方法
        System.out.println("Hello this is in Child");
    }
}
