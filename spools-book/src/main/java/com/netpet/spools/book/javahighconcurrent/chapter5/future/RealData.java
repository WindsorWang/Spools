
package com.netpet.spools.book.javahighconcurrent.chapter5.future;

/**
 * Created by woncz on 2017/7/26.
 */
public class RealData implements Data {

    protected final String result;

    public RealData(String param) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(param);
        }
        try {
            Thread.sleep(100); // 模拟耗时操作
        } catch (InterruptedException e) {

        }
        result = sb.toString();
    }

    @Override
    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "RealData{" +
                "result='" + result + '\'' +
                '}';
    }
}
