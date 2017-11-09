/*
 * Copyright [2017]
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

package com.netpet.spools.book.javaprogramoptimize.chapter2.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * Created by woncz on 2017/11/8.
 */
public class JdkMain {

    public static void main(String[] args) {
        IDBQuery query = JdkMain.createJdkProxy();
        String ts = query.request(1L, 2L);
        System.out.println("client = " + ts);
    }

    /**
     * 生成JDK动态代理
     *
     * @return
     */
    public static IDBQuery createJdkProxy() {
        IDBQuery jdkProxy = (IDBQuery) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                new Class[]{IDBQuery.class},
                new JdkDbQueryHandler());
        return jdkProxy;
    }
}
