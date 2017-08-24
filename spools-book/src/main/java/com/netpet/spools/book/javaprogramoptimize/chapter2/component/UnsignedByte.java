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

package com.netpet.spools.book.javaprogramoptimize.chapter2.component;

/**
 * Created by woncz on 2017/8/18.
 */
public class UnsignedByte {

    public short getValue(byte i) {
        short li = (short) (i & 0xff);
        return li;
    }

    public byte toUnsignedByte(Short i) {
        return (byte) (i & 0xff);
    }

    public static void main(String[] args) {
        short s = 200;
        UnsignedByte unsignedByte = new UnsignedByte();
        System.out.println(unsignedByte.toUnsignedByte(s));

        short[] shorts = new short[256];
        for (int i = 0; i < shorts.length; i++) {
            shorts[i] = (short) i;
        }
        byte[] bytes = new byte[256];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = unsignedByte.toUnsignedByte(shorts[i]);
        }

        for (int i = 0; i < bytes.length; i++) {
            System.out.print(unsignedByte.getValue(bytes[i]) + " ");
        }
    }
}
