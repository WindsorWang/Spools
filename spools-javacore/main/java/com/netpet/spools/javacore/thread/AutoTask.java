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

package com.netpet.spools.javacore.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class AutoTask extends TimerTask {

	private Timer timer = null;
	
	@Override
	public void run() {
		System.out.println(new Date());
	}

	public void init() {
		this.timer=new Timer(true);          
        this.timer.schedule(this, 3 * 1000, 1 * 1000);
        this.run();
	}
}
