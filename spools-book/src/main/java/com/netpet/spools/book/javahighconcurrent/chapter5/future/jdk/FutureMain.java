package com.netpet.spools.book.javahighconcurrent.chapter5.future.jdk;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by woncz on 2017/7/26.
 */
public class FutureMain {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        // 构建FutureTask
        FutureTask<String> futureTask = new FutureTask<>(new RealData("a"));
        ExecutorService es = Executors.newFixedThreadPool(1);
        es.submit(futureTask);

        System.out.println("请求完毕");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //System.out.println("一直等，" + "数据 : " + futureTask.get());
        System.out.println("不等了");
        long finishTime = System.currentTimeMillis();
        System.out.println("cost time : " + (finishTime - startTime) / 1000 + "s");
        es.shutdown();
    }
}
