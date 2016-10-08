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

package com.netpet.spools.javacore.thread;

/**
 * Created with IntelliJ IDEA.
 * User: David
 * Date: 13-11-30
 * Time: 下午10:39
 */
public class OurClass extends Thread{
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print("Hello");
        }
    }
}
