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

package com.netpet.spools.javacore.filelog;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Created with IntelliJ IDEA.
 * User: David
 * Date: 14-5-6
 * Time: 下午9:38
 * Desc: 根据文件名数组批量创建文件
 */
public class CreateFiles {
    public static void main(String[] args) throws Exception {
        String[] files = {"testFile"};
        for (int i = 0; i < files.length; i++) {
            FileWriter fw = new FileWriter("E:\\"+files[i]+".html");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("");
            fw.flush();
            bw.close();
            fw.close();
        }
    }
}
