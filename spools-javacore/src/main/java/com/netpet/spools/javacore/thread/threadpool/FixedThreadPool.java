/*
 * Copyright [2016]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netpet.spools.javacore.thread.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: David
 * Date: 14-6-10
 * Time: 上午10:17
 */


public class FixedThreadPool {

    public static List<Double> queue;
    public ExecutorService threadPool;

    public FixedThreadPool() {
        queue = new ArrayList<Double>();
        //产生一个 ExecutorService 对象，这个对象带有一个大小为 poolSize 的线程池，若任务数量大于 poolSize ，任务会被放在一个 queue 里顺序执行。
        threadPool = Executors.newFixedThreadPool(5);
    }

    public static void main(String[] args) {
        FixedThreadPool outer = new FixedThreadPool();
        FixedThreadPool.Manager inner = outer.new Manager();
        Thread consumer = new Thread(inner);

        Thread producer = new Thread() {//用于向queue中放入数据
            public void run() {
                while (true) {
                    synchronized (queue) {
                        double time = 1d;
                        long startTime = System.currentTimeMillis();
                        if (System.currentTimeMillis() - startTime >= time) {
                            startTime = System.currentTimeMillis();
                            for (int i = 0; i < 10; i++) {
                                queue.add((Math.random() * 10000));
                            }
                            queue.notify();
                        }
                    }
                }
            }
        };
        consumer.start();//启动守护线程，采用线程池来从queue中读取数据
        producer.start();
    }

    class Manager implements Runnable {
        int num = 0;
        public void run() {
            while (true) {
                try {
                    synchronized (queue) {
                        System.out.println("队列的长度为:" + queue.size());
                        while (queue.isEmpty()) {
                            queue.wait();
                        }
                        double result = queue.remove(0);
                        num++;
                        System.out.println("成功从队列中取到数据！" + num);
                        threadPool.execute(new ExecutorThread(result));
                    }
                } catch (InterruptedException t) {
                    break;
                }
            }
            threadPool.shutdown();
        }
    }

    class ExecutorThread implements Runnable {

        private double value;

        public ExecutorThread(double value) {
            this.value = value;
        }

        public void run() {
            System.out.println("This is " + Thread.currentThread().getName() + " " + value);
        }
    }
}