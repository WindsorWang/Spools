package com.netpet.spools.book.springboot.chapter2.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by woncz on 2017/8/2.
 */
@Service
@Scope("prototype")
public class DemoPrototypeService {
}
