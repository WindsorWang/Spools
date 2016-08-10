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

package com.netpet.spools.javacore.study.proxy.springcase;
import java.lang.reflect.Proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.netpet.spools.javacore.study.proxy.MyHandler;
import com.netpet.spools.javacore.study.proxy.RealSubject;
import com.netpet.spools.javacore.study.proxy.Subject;

public class testProxyClient {

    /**
     * Use the Spring for calling the Proxy Class.
     *
     * @param args
     */
    public static void main(String[] args) {
        //通过Spring的DI，得到Bean实例。
        ApplicationContext ctx = new FileSystemXmlApplicationContext("bean.xml");
        System.out.println(Subject.class.getCanonicalName());
        Subject sub = (Subject) ctx.getBean(Subject.class.getCanonicalName());

        MyHandler handler1 = new MyHandler();
        MyHandler handler2 = new MyHandler();

        handler1.SetSub(sub); //授权

        Subject proxySub1 = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(), RealSubject.class.getInterfaces(), handler1);
        Subject proxySub2 = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(), RealSubject.class.getInterfaces(), handler2);

        proxySub1.sailBook();

        proxySub2.sailBook();
    }

}
