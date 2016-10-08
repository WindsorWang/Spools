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

package com.netpet.spools.javacore.gc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Date;

import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: David
 * Date: 14-6-10
 * Time: 上午9:52
 * Desc: 弱引用
 */
public class WeakRef {

    static WeakRef a;
    public void finalize() {
        try {
            super.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        a = this;
    }

    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue queue = new ReferenceQueue();

        WeakReference ref = new WeakReference(new WeakRef(), queue);

        assertNotNull(ref.get());

        if (ref.get() == null) {
            System.out.println("AAA" + new Date());
        } else {
            System.out.println("BBB" + new Date());
        }

        Object obj = null;

        obj = queue.poll();

        assertNull(obj);

        System.gc();

        Thread.sleep(10000);

        System.gc();

        assertNull(ref.get());

        if (ref.get() == null) {
            System.out.println("AAA" + new Date());
        } else {
            System.out.println("BBB" + new Date());
        }


        obj = queue.poll();

        assertNotNull(obj);

    }
}


