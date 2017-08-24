/*
 * Copyright [2017]
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

package com.netpet.spools.book.insidethejavavirtualmachine.chapter18;

/**
 * Created by woncz on 2017/8/24.
 */
public class FinallyTest {

    public static void main(String[] args) {
        System.out.println(dosth());
    }

    private static int dosth() {
        int i = 1;
        try {
            i = 2;
            int a = i / 0;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        } finally {
            i = 3;
            System.out.println(i);
        }
        return i;
    }

}
