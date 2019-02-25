package org.yabo.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class S2 {
    private S1 s1;

    public S2() {
        System.out.println("s2 construct.."+Thread.currentThread());
    }

    public void test(){
        System.out.println(s1);
    }

    @Autowired
    public void setS1(S1 s1) {
        System.out.println("s2 set s1");
        this.s1 = s1;
    }
}
