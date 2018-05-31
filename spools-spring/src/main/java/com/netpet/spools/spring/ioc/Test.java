package com.netpet.spools.spring.ioc;

import com.netpet.spools.spring.ioc.core.JsonApplicationContext;
import com.netpet.spools.spring.ioc.entity.Robot;

public class Test {

    public static void main(String[] args) throws Exception {
        JsonApplicationContext applicationContext = new JsonApplicationContext("application.json");
        applicationContext.init();
        Robot robot = (Robot) applicationContext.getBean("robot");
        robot.show();

    }
}
