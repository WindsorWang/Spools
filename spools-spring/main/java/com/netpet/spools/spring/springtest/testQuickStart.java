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

package com.netpet.spools.spring.springtest;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.netpet.spools.spring.springcase.Action;

public class testQuickStart {

	/**
	 * The special way (DI in Spring) for reading from config file.
	 * @param args
	 * Testing by Using Spring!
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("springTest/bean.xml");
		Action action = (Action) ctx.getBean("theAction");
		Action secondAction = (Action) ctx.getBean("secondAction");

		int i = 0;
		System.out.println(action.execute("Trigger Jonathan:") + i++);
		System.out.println(secondAction.execute("bootstrap:") + i++);


        for (i = 0; i < 10; i++) {
            if (i == 6) {
                continue;
            }
            System.out.println(i);
        }
	}

}
