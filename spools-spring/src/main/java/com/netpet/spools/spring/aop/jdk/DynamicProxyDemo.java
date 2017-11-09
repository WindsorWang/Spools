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

package com.netpet.spools.spring.aop.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by woncz on 2017/11/8.
 */
public class DynamicProxyDemo {

    public static void main(String[] args) {
        // 需要代理的接口，被代理类实现的多个接口都必须在这里定义
        Class[] proxyInterface = new Class[]{IBusiness.class, IBusiness2.class};
        // 构建AOP的Advice，这里需要传入业务类实例
        LogInvocationHandler logInvocationHandler = new LogInvocationHandler(new Business());
        // 生成代理类的字节码加载器
        ClassLoader classLoader = DynamicProxyDemo.class.getClassLoader();
        // 织入器，织入代码并生成代理类
        IBusiness proxyBusiness = (IBusiness) Proxy.newProxyInstance(classLoader, proxyInterface, logInvocationHandler);
        // 使用代理类的实例来调用方法
        proxyBusiness.doSomeThing();
        ((IBusiness2) proxyBusiness).doSomeThing2();
    }

    public static class LogInvocationHandler implements InvocationHandler {

        private Object target; // 目标对象

        LogInvocationHandler(Object o) {
            this.target = o;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // 执行原有逻辑
            Object rev = method.invoke(target, args);
            // 执行织入的日志，你可以控制哪些方法执行切入逻辑
            if (method.getName().equals("doSomeThing2")) {
                System.out.println("记录日志");
            }
            return rev;
        }
    }
}
