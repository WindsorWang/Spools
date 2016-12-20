package com.netpet.spools.javacore.binary;

import java.util.HashMap;

/**
 * Created by woncz on 2016/10/13.
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(new Integer(-390), "a");
        map.put(new Integer(34), "b");

        for (int h = 0; h > -10000; h--) {
            int a = hash(new Integer(h));

            System.out.println("a..=" + a + "\tindex=" + (a&(20-1)));
        }

        int h = hash(new Integer(-23));

        System.out.println("h=" + h);

        System.out.println("h=" + (h&(20-1)));
    }

    public static final int hash(Object k) {
        int h = 0;
        if (0 != h && k instanceof String) {
            return sun.misc.Hashing.stringHash32((String) k);
        }

        h ^= k.hashCode();

        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
}
