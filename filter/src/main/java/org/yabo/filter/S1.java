package org.yabo.filter;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

@Service
public class S1 implements BeanPostProcessor {
    private S2 s2;

    @Autowired
    public void setS2(S2 s2) {
        System.out.println("s1 set s2..."+Thread.currentThread());
        this.s2 = s2;
    }

    public void test() {
        System.out.println(s2);
    }

    public S1() {
        System.out.println("s1 construct...");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization");
        return bean;
    }
}
