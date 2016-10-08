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
 * Time: 上午8:59
 */
public class TestGc {

    public static void main(String args[]) {
        new TestGc();
        //int a[] = new int[3];
        //F f= new F();
        System.gc();
    }
    public void finalize() throws Throwable{
        super.finalize();
        System.out.println("finalize method was called!");
    }
}