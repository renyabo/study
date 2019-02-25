package org.yabo.servers.book.impl;

import org.springframework.stereotype.Component;
import org.yabo.servers.book.Filter;

@Component
public class Filter2 implements Filter {
    @Override
    public void doFilter() {
        System.out.println("filter 2 ...");
    }
}
