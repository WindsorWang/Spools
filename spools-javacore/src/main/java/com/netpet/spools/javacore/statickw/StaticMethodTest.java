package com.netpet.spools.javacore.statickw;

/**
 * 继承时，父类的static方法可以被隐藏但是不能被重写
 * Created by woncz on 2016/10/16.
 */
public class StaticMethodTest {
    public static void main(String[] args) {

    }
}

class Animal {
    static void eat() {
        System.out.println("Animal eat");
    }
}

class Dog extends Animal {
    //@Override 不能Override
    static void eat() {
        System.out.println("Dog eat");
    }
}
