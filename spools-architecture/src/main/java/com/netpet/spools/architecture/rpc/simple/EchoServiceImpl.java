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

/**
 * Created by woncz on 2016/10/8.
 */
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String ping) {
        return ping != null ? ping + " --> I am OK." : " I am OK.";
    }
}
