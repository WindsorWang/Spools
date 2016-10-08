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

package com.netpet.spools.javacore;

/**
 * Created with IntelliJ IDEA.
 * User: trigger
 * Date: 13-3-11
 * Time: 下午2:23
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Hello, ANT!!!");
        System.out.println("中国人民");

        String ts = "4,8";
        if (ts.indexOf("9") != -1) {
            System.out.println("aA");
        } else {
            System.out.println("zBB");
        }

        String mstsdn = "041012345678";
        String areaCode = mstsdn.substring(0,4);
        String servNum = mstsdn.substring(4);
        System.out.println(areaCode);
        System.out.println(servNum);
        if (mstsdn.indexOf("") == -1) {
            System.out.println("QQ");
        } else {
            System.out.println("SS");
        }

        String date = "20131212923456";
        System.out.println(date.substring(8));
    }

}
