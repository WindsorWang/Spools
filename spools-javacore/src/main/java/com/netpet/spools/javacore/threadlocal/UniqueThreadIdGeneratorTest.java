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

package com.netpet.spools.javacore.threadlocal;

/**
 * Created with IntelliJ IDEA.
 * User: trigger
 * Date: 13-4-1
 * Time: 下午4:01
 */
public class UniqueThreadIdGeneratorTest {
    public static void main(String[] args) {
        ThreadA t1 = new ThreadA();
        ThreadB t2 = new ThreadB();

        try {
            t1.run();
            t2.run();
            t1.display();
            t2.display();
            t1.sleep(2000);
            t2.sleep(3000);
            t1.display();
            t2.display();
            System.out.println(t1.getId() + "||" + t2.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
