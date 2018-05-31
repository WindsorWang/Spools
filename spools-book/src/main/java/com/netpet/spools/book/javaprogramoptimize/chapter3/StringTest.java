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

package com.netpet.spools.book.javaprogramoptimize.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args : -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
 * 测试subString方法
 * JDK7对字符串常量池做优化
 * Created by woncz on 2017/8/27.
 */
public class StringTest {
    public static void main(String[] args) {
        List<String> handler = new ArrayList<>();

        /**
         * HugeStr不到1000次就内存溢出
         * 但是ImprovedHuge不会
         */
        for (int i = 0; i < 1000; i++) {
            HugeStr h = new HugeStr();
            //ImprovedHugeStr h = new ImprovedHugeStr();
            handler.add(h.getSubString(1, 5));
        }
    }

    static class HugeStr {
        private String str = new String(new char[100000]);

        public String getSubString(int begin, int end) {
            return str.substring(begin, end);
        }
    }

    static class ImprovedHugeStr {
        private String str = new String(new char[100000]);

        public String getSubString(int begin, int end) {
            return new String(str.substring(begin, end));
        }
    }
}

