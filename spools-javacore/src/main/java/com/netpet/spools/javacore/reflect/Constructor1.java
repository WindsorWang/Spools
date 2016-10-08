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

import java.lang.reflect.Constructor;

/**
 * 通过反射得到构造器信息
 * Created by windsor on 2013/12/17.
 */
public class Constructor1 {
    public Constructor1() {
    }

    protected Constructor1(int i, double d) {
    }

    public static void main(String args[]) {
        try {
            Class cls = Class.forName("com.reflect.Constructor1");
            Constructor ctorlist[] = cls.getDeclaredConstructors();
            for (int i = 0; i < ctorlist.length; i++) {
                Constructor ct = ctorlist[i];
                System.out.println("name = " + ct.getName());
                System.out.println("decl class = " + ct.getDeclaringClass());
                Class pvec[] = ct.getParameterTypes();
                for (int j = 0; j < pvec.length; j++)
                    System.out.println("param #" + j + " " + pvec[j]);
                Class evec[] = ct.getExceptionTypes();
                for (int j = 0; j < evec.length; j++)
                    System.out.println("exc #" + j + " " + evec[j]);
                System.out.println("-----");
            }
        } catch (Throwable e) {
            System.err.println(e);
        }
    }
}