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
