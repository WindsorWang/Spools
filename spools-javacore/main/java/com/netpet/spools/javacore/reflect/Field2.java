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

import java.lang.reflect.Field;

/**
 * 改变字段(域)的值
 * Created by windsor on 2013/12/17.
 */
public class Field2 {
    public double d;

    public static void main(String args[]) {
        try {
            Class cls = Class.forName("com.reflect.Field2");
            Field fld = cls.getField("d");
            Field2 f2obj = new Field2();
            System.out.println("d = " + f2obj.d);
            fld.setDouble(f2obj, 12.34);
            System.out.println("d = " + f2obj.d);
        } catch (Throwable e) {
            System.err.println(e);
        }
    }
}