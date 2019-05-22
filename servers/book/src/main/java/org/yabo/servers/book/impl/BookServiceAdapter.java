package org.yabo.servers.book.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.yabo.service.book.BookService;

public abstract class BookServiceAdapter implements BookService {
    @Autowired
    Service1 service1;

    protected void test(){
        System.out.println(service1);
        service1.test();
    }
}
