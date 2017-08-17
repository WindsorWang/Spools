package com.netpet.spools.book.java8lambdas.chapter2;

import java.awt.event.ActionListener;

/**
 * Created by woncz on 2017/8/8.
 */
public class LambdaTest {

    private Runnable noArguments = () -> System.out.println("Hello world");

    private Runnable multiStatement = () -> {
        System.out.println("Hello ");
        System.out.println("world");
    };

    private ActionListener oneArgument = event -> System.out.println("button clicked");

    public void test() {
        Thread t1 = new Thread(noArguments, "t1");
        t1.start();

        Thread t2 = new Thread(multiStatement, "t2");
        t2.start();
    }

    public static void main(String[] args) {
        LambdaTest test = new LambdaTest();
        test.test();
    }
}
