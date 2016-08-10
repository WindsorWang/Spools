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

package com.netpet.spools.spring.springcase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import org.apache.commons.beanutils.BeanUtils;

public class ActionFactory {
	public static Action getAction(String actionName) {
		Properties pro = new Properties();
		
		try {
			pro.load(new FileInputStream(System.getProperty("user.dir") + "/springTest/" + "config.properties"));
			String actionImplName = (String) pro.get(actionName);
			String actionMessage = (String)pro.get(actionName+"_msg");
			Object obj = Class.forName(actionImplName).newInstance();
			BeanUtils.setProperty(obj,"message",actionMessage);
			
			return (Action) obj;
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(InstantiationException e) {
			e.printStackTrace();
		}catch(IllegalAccessException e) {
			e.printStackTrace();
		}catch(InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

}
