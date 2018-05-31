/*
 * Copyright (C) 2014-2020 Nuhtech Technology(Beijing) Co.,Ltd.
 *
 * All right reserved.
 *
 * This software is the confidential and proprietary
 * information of Nuhtech Company of China.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with Nuhtech inc.
 *
 */

package com.netpet.spools.book.java8inaction.sort;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author admin
 * @date 2018/4/7
 */
public class SortTest {

    public static void main(String[] args) {
        SortTest test = new SortTest();
        test.test();
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);

    }

    public void test() {
        List<Apple> appleList = new ArrayList<>();

        Apple a1 = new Apple("a1", "red", 10);
        Apple a2 = new Apple("a2", "black", 8);
        Apple a3 = new Apple("a3", "yellow", 9);

        appleList.add(a1);
        appleList.add(a2);
        appleList.add(a3);

        System.out.println(appleList);

        appleList = appleList.stream().sorted(Comparator.comparingDouble(Apple::getWeight)).collect(Collectors.toList());

        System.out.println(appleList);

        Predicate<Apple> redApplyFilter = a -> "red".equals(a.getColor());

        appleList.stream().filter(redApplyFilter).forEach(apple -> {
            System.out.println(apple);
        });

    }
}

