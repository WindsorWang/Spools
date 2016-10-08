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

package com.netpet.spools.javacore.memcached.test;

import java.util.Date;

//import com.danga.MemCached.MemCachedClient;
//import com.danga.MemCached.SockIOPool;

/**
 * Created by windsor on 2016/7/27.
 */
public class Test {
    /**
    protected static MemCachedClient mcc = new MemCachedClient();

    static {
        String[] servers = {"127.0.0.1:8080"};

        Integer[] weights = {3};

        //创建一个实例对象SockIOPool     
        SockIOPool pool = SockIOPool.getInstance();

        // set the servers and the weights    
        //设置Memcached Server    
        pool.setServers(servers);
        pool.setWeights(weights);

        // set some basic pool settings       
        // 5 initial, 5 min, and 250 max conns       
        // and set the max idle time for a conn       
        // to 6 hours       
        pool.setInitConn(5);
        pool.setMinConn(5);
        pool.setMaxConn(250);
        pool.setMaxIdle(1000 * 60 * 60 * 6);

        // set the sleep for the maint thread       
        // it will wake up every x seconds and       
        // maintain the pool size       
        pool.setMaintSleep(30);

        // Tcp的规则就是在发送一个包之前，本地机器会等待远程主机    
        // 对上一次发送的包的确认信息到来；这个方法就可以关闭套接字的缓存，
        // 以至这个包准备好了就发；
        pool.setNagle(false);
        //连接建立后对超时的控制    
        pool.setSocketTO(3000);
        //连接建立时对超时的控制    
        pool.setSocketConnectTO(0);

        // initialize the connection pool       
        //初始化一些值并与MemcachedServer段建立连接    
        pool.initialize();


        // lets set some compression on for the client       
        // compress anything larger than 64k       
        mcc.setCompressEnable(true);
        mcc.setCompressThreshold(64 * 1024);
    }

    public static void bulidCache() {
        //set(key,value,Date) ,Date是一个过期时间，如果想让这个过期时间生效的话，这里传递的new Date(long date) 中参数date，需要是个大于或等于1000的值。    
        //因为java client的实现源码里是这样实现的 expiry.getTime() / 1000 ，也就是说，如果 小于1000的值，除以1000以后都是0，即永不过期    
        mcc.set("test", "This is a springtest String", new Date(11211));
        //十秒后过期

    }

    public static void output() {
        //从cache里取值    
        String value = (String) mcc.get("test");
        System.out.println(value);
    }

    public static void main(String[] args) {
        bulidCache();
        output();
    }
     */

}       

