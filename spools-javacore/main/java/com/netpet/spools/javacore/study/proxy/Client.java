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

package com.netpet.spools.javacore.study.proxy;

import java.lang.reflect.Proxy;

/**
 * 客户端，测试类
 *
 * @author windsor
 */
public class Client {
    public static void main(String[] args) {
        Subject sub = new RealSubject();
        MyHandler handler1 = new MyHandler();
        MyHandler handler2 = new MyHandler();

        handler1.SetSub(sub); //授权

        Subject proxySub1 = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(), RealSubject.class.getInterfaces(), handler1);
        Subject proxySub2 = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(), RealSubject.class.getInterfaces(), handler2);

        proxySub1.sailBook();

        proxySub2.sailBook();

    }
}

