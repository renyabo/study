package org.yabo.servers.book.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.yabo.service.book.BookChildService;

public abstract class BookServiceAdapter implements BookChildService {
    @Autowired
    Service1 service1;

    protected void test(){
        System.out.println(service1);
        service1.test();
    }
}
