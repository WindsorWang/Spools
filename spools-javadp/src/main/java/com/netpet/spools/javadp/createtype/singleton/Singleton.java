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

package com.netpet.spools.javadp.createtype.singleton;

/**
 * Design Pattern of Singleton
 * 以下代码中，Singleton被加载时其内部类并不会被初始化，所以instance并不会被实例化，直到getInstance方法被调用时才会加载SingleHolder类，
 * 由于实例化是在类加载时完成，故对多线程友好，也不需要同步关键字。
 */
public class Singleton {
    //core part:default constructor is private.
    private Singleton() {
    }

    //called point for outer world
    public static Singleton getInstance() {
        return SingletonInstance.singleton;
    }

    //static inner class
    private static class SingletonInstance {
        private static final Singleton singleton = new Singleton();
    }
}
