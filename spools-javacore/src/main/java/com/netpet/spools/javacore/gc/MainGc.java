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

package com.netpet.spools.javacore.gc;

/**
 * Created with IntelliJ IDEA.
 * User: David
 * Date: 14-6-10
 * Time: 上午9:08
 * Desc: 对象重生的例子
 */

class C {
    static A a;
}

class A {
    B b;

    public A(B b) {
        this.b = b;
    }

    @Override
    public void finalize() {
        System.out.println("A finalize");
        C.a = this;                 //Key point 对象再生
    }
}

class B {
    String name;
    int age;

    public B(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void finalize() {
        System.out.println("B finalize");
    }

    @Override
    public String toString() {
        return name + " is " + age;
    }
}

public class MainGc {
    public static void main(String[] args) throws Exception {
        A a = new A(new B("allen", 20));
        a = null;

        System.gc();
        Thread.sleep(5000);
        System.out.println(C.a.b);
    }
}
