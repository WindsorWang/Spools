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

package com.netpet.spools.javadp.createtype.abstractfactory.testcase;

import com.netpet.spools.javadp.createtype.abstractfactory.ChicagoPizzaStore;
import com.netpet.spools.javadp.createtype.abstractfactory.NYPizzaStore;

/**
 * Created with IntelliJ IDEA.
 * User: David
 * Date: 2015/1/19
 * Time: 10:56
 */

public class AbstractFactoryTestCase {
    public static void main(String[] args) {
        NYPizzaStore pizzaStore = new NYPizzaStore();
        pizzaStore.orderPizza("cheese");

        ChicagoPizzaStore pizzaStore1 = new ChicagoPizzaStore();
        pizzaStore1.orderPizza("cheese");
    }
}
