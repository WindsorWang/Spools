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

package com.netpet.spools.book.javahighconcurrent.chapter6;

import java.util.stream.IntStream;

import com.netpet.spools.book.javahighconcurrent.chapter6.util.PrimeUtil;

/**
 * @desc 并行流与并行排序
 * Created by woncz on 2017/5/8.
 */
public class Se4Parallel {

    // 1. 统计数据范围内所有质数的数量
    public int countPrime(int start, int end) {
        long count = IntStream.range(start, end).filter(PrimeUtil::isPrime).count();
        return (int) count;
    }

    public int countPrimeParallel(int start, int end) {
        long count = IntStream.range(start, end).parallel().filter(PrimeUtil::isPrime).count();
        return (int) count;
    }


    public static void main(String[] args) {
        Se4Parallel se4Parallel = new Se4Parallel();
        long startTime = System.currentTimeMillis();
        System.out.println("start:" + startTime);
        long count = se4Parallel.countPrimeParallel(1, 100000000);
        System.out.println(count);
        long endTime = System.currentTimeMillis();
        System.out.println("end:" + endTime);
        System.out.println("cost : " + (endTime - startTime) / 1000);

        startTime = System.currentTimeMillis();
        System.out.println("start:" + startTime);
        count = se4Parallel.countPrime(1, 100000000);
        System.out.println(count);
        endTime = System.currentTimeMillis();
        System.out.println("end:" + endTime);
        System.out.println("cost : " + (endTime - startTime) / 1000);


    }

}
