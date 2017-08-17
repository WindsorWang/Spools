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

package com.netpet.spools.book.javahighconcurrent.chapter6.util;

/**
 * Created by woncz on 2017/5/8.
 */
public class PrimeUtil {

    public static boolean isPrime(int number) {
        int tmp = number;
        if (tmp < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (tmp % i == 0) {
                return false;
            }
        }
        return true;
    }
}
