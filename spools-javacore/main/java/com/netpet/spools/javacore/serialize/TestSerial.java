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

package com.netpet.spools.javacore.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Serial implements Serializable {

    private static final long serialVersionUID = 1L;

    public byte version = 100;

    public byte count = 0;

}

public class TestSerial {
    public static void main(String[] args) {
        TestSerial ts = new TestSerial();
        try {
            ts.test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void test() throws Exception {
        //output
        FileOutputStream fos = new FileOutputStream("F://temp.out");

        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Serial ts = new Serial();

        oos.writeObject(ts);

        oos.flush();

        oos.close();

        //input
        FileInputStream fis = new FileInputStream("F://temp.out");

        ObjectInputStream oin = new ObjectInputStream(fis);

        Serial ts1 = (Serial) oin.readObject();

        System.out.println("version=" + ts1.version);
    }
}
