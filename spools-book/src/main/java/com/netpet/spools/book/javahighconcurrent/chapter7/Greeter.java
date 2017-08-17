package com.netpet.spools.book.javahighconcurrent.chapter7;

import akka.actor.UntypedActor;

/**
 * Created by woncz on 2017/7/31.
 */
public class Greeter extends UntypedActor {

    public static enum Msg {
        GREET, DONE
    }

    @Override
    public void onReceive(Object o) throws Exception {
        if (o == Msg.GREET) {
            System.out.println("Hello world");
            getSender().tell(Msg.DONE, getSelf());
        } else {
            unhandled(o);
        }
    }
}
