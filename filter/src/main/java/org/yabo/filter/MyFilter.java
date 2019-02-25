package org.yabo.filter;

import org.springframework.stereotype.Component;

@Component
public class MyFilter implements Filter {

    public MyFilter() {
        System.out.println("myfilter construct..."+Thread.currentThread());
    }

    @Override
    public void doFilter() {
        System.out.println("myFilter...");
    }
}
