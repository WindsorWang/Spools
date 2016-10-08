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

import com.netpet.spools.javadp.createtype.abstractfactory.model.*;
import com.netpet.spools.javadp.createtype.abstractfactory.model.chicago.*;
import com.netpet.spools.javadp.createtype.abstractfactory.model.ny.ThinCrustDough;

/**
 * Created with IntelliJ IDEA.
 * User: David
 * Date: 15-1-18
 * Time: 下午9:51
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new Mozzarella();
    }

    @Override
    public Clams createClam() {
        return new FrozenClams();
    }

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Pepperoni createPeperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[] {new BlackOlives(), new EggPlant(), new Spinach(), };
    }
}
