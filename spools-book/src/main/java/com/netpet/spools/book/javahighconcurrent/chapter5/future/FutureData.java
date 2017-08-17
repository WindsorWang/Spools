package com.netpet.spools.book.javahighconcurrent.chapter5.future;

/**
 * Created by woncz on 2017/7/26.
 */
public class FutureData implements Data {

    protected RealData realData = null; // FutureData是RealData的包装

    protected boolean isReady = false;

    @Override
    public synchronized String getResult() {
        while (!isReady) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }
        return realData.result;
    }

    public synchronized void setRealData(RealData realData) {
        if (isReady) {
            return;
        }
        this.realData = realData;
        isReady = true;
        notifyAll();
    }

    @Override
    public String toString() {
        return "FutureData{" +
                "realData=" + realData +
                ", isReady=" + isReady +
                '}';
    }
}
