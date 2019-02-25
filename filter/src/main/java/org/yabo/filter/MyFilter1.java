package org.yabo.filter;

import org.springframework.stereotype.Component;

@Component
public class MyFilter1 implements Filter {

    public MyFilter1() {
        System.out.println("myfilter1 construct..."+Thread.currentThread());
    }

    @Override
    public void doFilter() {
        System.out.println("myFilter1...");
    }
}
