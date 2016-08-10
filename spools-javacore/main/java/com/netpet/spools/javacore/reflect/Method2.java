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

package com.netpet.spools.javacore.reflect;

import java.lang.reflect.Method;

/**
 * Created by windsor on 2013/12/17.
 */
public class Method2 {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String args[]) {
        try {
            Class cls = Class.forName("com.reflect.Method2");
            Class partypes[] = new Class[2];
            partypes[0] = Integer.TYPE;
            partypes[1] = Integer.TYPE;

            Method meth = cls.getMethod("add", partypes);
            Method2 methobj = new Method2();
            Object arglist[] = new Object[2];
            arglist[0] = new Integer(37);
            arglist[1] = new Integer(47);
            Object retobj = meth.invoke(methobj, arglist);
            Integer retval = (Integer) retobj;
            System.out.println(retval.intValue());
        } catch (Throwable e) {
            System.err.println(e);
        }
    }
}
