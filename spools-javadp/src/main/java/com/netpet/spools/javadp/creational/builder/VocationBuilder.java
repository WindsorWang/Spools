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

package com.netpet.spools.javadp.createtype.builder;

/**
 * Created with IntelliJ IDEA.
 * User: David
 * Date: 2015/1/21
 * Time: 15:15
 */
public class VocationBuilder extends AbstractBuilder {
    StringBuilder vocation = new StringBuilder();

    @Override
    public void buildDay() {
        vocation.append("day-");
    }

    @Override
    public void addHotel() {
        vocation.append("hotel-");
    }

    @Override
    public void addReservation() {
        vocation.append("reservation-");
    }

    @Override
    public void addSpecialEvent() {

    }

    @Override
    public void addTickets() {

    }

    @Override
    public VocationPlanner getVocationPlanner() {
        return new VocationPlanner(vocation.toString());
    }
}
