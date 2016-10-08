/*
 * Copyright (C) 2014-2016 Beijing BaoJiaBei Technology Co.,Ltd.
 * 
 * All right reserved.
 * 
 * This software is the confidential and proprietary
 * information of BaoJiaBei Company of China. 
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement 
 * you entered into with BaoJiaBei inc.
 *
 */

package com.netpet.spools.architecture.rpc.simple;

import java.net.InetSocketAddress;

/**
 * Created by woncz on 2016/10/8.
 */
public class RpcTest {
    public static void main(String[] args) throws Exception {
        // 1. 服务端
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    RpcExporter.exporter("localhost", 8082);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "Rpc-Server").start();

        // 2. 客户端
        RpcImporter<EchoService> importer = new RpcImporter<>();
        EchoService echoService = importer.importer(EchoServiceImpl.class, new InetSocketAddress("localhost", 8082));
        System.out.println(echoService.echo("Are you OK ?"));
    }
}
