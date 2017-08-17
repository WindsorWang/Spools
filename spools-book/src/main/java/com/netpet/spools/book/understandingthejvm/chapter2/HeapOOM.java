
package com.netpet.spools.book.understandingthejvm.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args: -Xms 20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * Created by woncz on 2017/8/9.
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }

}
