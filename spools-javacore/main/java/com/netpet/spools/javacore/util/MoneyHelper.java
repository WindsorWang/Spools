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

package com.netpet.spools.javacore.util;

public class MoneyHelper {

    private static final String[] UNITS = {"亿","仟","佰","拾","万","仟","佰","拾","" };
    private static final String[] CHINESE_NUMBER = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};

    public static String convert(long yuan) {

//        String ts = "这时就可以选择中文字体了，再更改为你想要的字体。";

        if (yuan >= 1e9 || yuan < 0) {
            return "这个数字超出解析范围了！";
        }
        String amount = String.valueOf(yuan);
        int len = amount.length();
        int unitsLen = UNITS.length;

        String chineseCurrency = "";
        for (int i = len - 1; i >= 0; i--) {
            chineseCurrency = number(amount.charAt(i)) + unit(amount.charAt(i), unitsLen - len + i) +chineseCurrency;
        }

        chineseCurrency = chineseCurrency.replaceAll("零+","零");
        chineseCurrency =  chineseCurrency + "元整";
        chineseCurrency = chineseCurrency.replaceAll("零万","万");
        chineseCurrency = chineseCurrency.replaceAll("零元","元");

        return chineseCurrency;
    }

    private static String number(char number) {
         return CHINESE_NUMBER[Integer.parseInt(String.valueOf(number))];
    }

    private static String unit(char number, int pos) {
        if(number == '0') {
            return "";
        }
        return UNITS[pos];
    }
}
