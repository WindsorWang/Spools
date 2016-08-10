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

import java.io.File;

import com.netpet.spools.spring.springcase.Action;
import com.netpet.spools.spring.springcase.ActionFactory;

/**
 * 
 * @author camel49
 *
 */
public class testFactory {

	/**
	 * Traditional way for reading from the config file.
	 * @param args
	 */
	public static void main(String[] args) {
        System.out.println(
                Thread.currentThread().getContextClassLoader().getResource(""));
        System.out.println(testFactory.class.getClassLoader().getResource(""));
        System.out.println(ClassLoader.getSystemResource(""));

        System.out.println(testFactory.class.getResource(""));
        System.out.println(testFactory.class.getResource("/"));


        System.out.println(new File("").getAbsolutePath());
        System.out.println(System.getProperty("user.dir"));
		Action action = ActionFactory.getAction("TheAction");
		System.out.println(action.execute("Rod Johnson"));

	}

}
