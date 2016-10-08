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

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 网上代理商代理类  --Key Part
 *
 * @author windsor
 */
public class MyHandler implements InvocationHandler {

    private Object realSub = null;

    public void SetSub(Object obj) {
        this.realSub = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        if (this.realSub == null) {
            System.out.println("你无权操作!");//判断权限
            return null;
        } else {
            String dazhe = DaZhe();
            System.out.println(dazhe);
            Object rtObj = method.invoke(this.realSub, args);
            String give = Give();
            System.out.println(give);
            String log = dazhe + give + "-" + new Date();
            System.out.println(log);
            return rtObj;
        }
    }

    private String DaZhe() {
        return "打折信息";
    }

    private String Give() {
        return "送代金券";
    }
}
