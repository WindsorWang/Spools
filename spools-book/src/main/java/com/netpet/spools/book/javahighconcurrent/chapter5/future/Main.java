package com.netpet.spools.book.javahighconcurrent.chapter5.future;

/**
 * Created by woncz on 2017/7/26.
 */
public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        Data data = client.request("name");

        System.out.println("请求完毕 : " + data);

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {

        }

        System.out.println("数据 : " + data);
    }
}
