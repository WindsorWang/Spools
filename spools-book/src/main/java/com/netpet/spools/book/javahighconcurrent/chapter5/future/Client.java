package com.netpet.spools.book.javahighconcurrent.chapter5.future;

/**
 * Created by woncz on 2017/7/26.
 */
public class Client {

    public Data request(final String queryStr) {
        final FutureData futureData = new FutureData();
        new Thread() {
            public void run() {
                RealData realData = new RealData(queryStr);
                futureData.setRealData(realData);
            }
        }.start();

        return futureData;
    }
}
