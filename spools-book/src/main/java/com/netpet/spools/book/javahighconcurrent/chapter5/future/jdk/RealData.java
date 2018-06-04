
package com.netpet.spools.book.javahighconcurrent.chapter5.future.jdk;

import java.util.concurrent.Callable;

/**
 * Created by woncz on 2017/7/26.
 */
public class RealData implements Callable<String> {

    private String param;

    public RealData(String param) {
        this.param = param;
    }
    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            sb.append(param);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("finishing the future thread");
        return sb.toString();
    }
}
