
package com.netpet.spools.book.understandingthejvm.chapter3;

/**
 * 长期存活的对象进入老年代
 * VM Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+UseSerialGC
 * Created by woncz on 2017/8/10.
 */
public class LongTermBigObject2OldGen {

    private static final int _1M = 1024 * 1024;

    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1M / 4];

        // 什么时候及你如老年代取决于 XX:MaxTenuringThreshold设置
        allocation2 = new byte[4 * _1M];
        allocation3 = new byte[4 * _1M];
        allocation3 = null;
        allocation3 = new byte[4 * _1M];

    }

    public static void main(String[] args) {
        LongTermBigObject2OldGen.testTenuringThreshold();
    }
}
