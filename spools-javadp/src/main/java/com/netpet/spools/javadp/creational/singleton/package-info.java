/*
 * Copyright [2020]
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

package com.netpet.spools.javadp.creational.singleton;

// 单例模式实现方式
// 1. 饿汉式(shortcoming or good)
// 2. 懒汉式(good or shortcoming)
// 3. double check with volatile (as-if-serial syntax, lock's optimization )
// 4. 静态内部类(class load's mechanism)
// 5. 枚举类(Enum) 限制是不能继承超类

// 安全性
// 1. 反射, AccessibleObject.setAccessible 破坏私有构造方法
// 2. 序列化, implements serializable, readObject() { return INSTANCE};