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

package com.netpet.spools.javadp.createtype.builder.testcase;

import com.netpet.spools.javadp.createtype.builder.Planner;
import com.netpet.spools.javadp.createtype.builder.SystemInstallDirector;
import com.netpet.spools.javadp.createtype.builder.VocationBuilder;
import com.netpet.spools.javadp.createtype.builder.Windows7InstallBuilder;

/**
 * Created with IntelliJ IDEA.
 * User: David
 * Date: 2015/1/21
 * Time: 15:11
 */
public class BuilderTestCase {
    public static void main(String[] args) {
        VocationBuilder builder = new VocationBuilder();

        builder.buildDay();
        builder.addHotel();
        builder.addReservation();

        Planner myPlanner = builder.getVocationPlanner();
        myPlanner.schedual();


        //first:未用生成器模式
        Windows7InstallBuilder builder1 = new Windows7InstallBuilder();
        builder1.backupData();
        builder1.copyData();
        builder1.formatDisk();
        builder1.installApplication();
        //Result: 错误，复制数据应该在格式化硬盘之后进行

        //second:使用生成器模式
        Windows7InstallBuilder builder2 = new Windows7InstallBuilder();
        SystemInstallDirector director = new SystemInstallDirector(builder2);
        director.installSystem();
    }
}
