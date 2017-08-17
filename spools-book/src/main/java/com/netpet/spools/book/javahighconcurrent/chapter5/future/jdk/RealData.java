
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
    public String call() throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(param);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        }
        return sb.toString();
    }
}
