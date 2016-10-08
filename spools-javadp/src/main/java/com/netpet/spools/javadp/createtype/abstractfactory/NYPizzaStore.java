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

package com.netpet.spools.javadp.createtype.abstractfactory;

/**
 * Created with IntelliJ IDEA.
 * User: David
 * Date: 15-1-18
 * Time: 下午9:33
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    protected Pizza createPizza(String item) {
        Pizza pizza = null;

        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        if("cheese".equals(item)){
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        } else if("veggie".equals(item)) {
            pizza = new VeggiePizza(ingredientFactory);
            pizza.setName("New York Style Veggies Pizza");
        } else if("clam".equals(item)) {
            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("New York Style Clam Pizza");
        } else if("pepperoni".equals(item)) {
            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("New York Style Pepperoni Pizza");
        }
        return pizza;
    }
}
