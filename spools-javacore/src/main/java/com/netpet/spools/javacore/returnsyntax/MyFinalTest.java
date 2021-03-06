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

package com.netpet.spools.javacore.returnsyntax;

/**
 * Created with IntelliJ IDEA.
 * User: David
 * Date: 2015/1/20
 * Time: 10:18
 */
public class MyFinalTest {

    public int doMethod() {
        try {
            throw new Exception();
        } catch (Exception ex) {
            return 5;
        } finally {
            return 10;
        }
    }

    public static void main(String[] args) {
        MyFinalTest testEx = new MyFinalTest();
        int rVal = testEx.doMethod();
        System.out.println("The return Val : " + rVal); //expected: [The return Val : 10]
    }
}


