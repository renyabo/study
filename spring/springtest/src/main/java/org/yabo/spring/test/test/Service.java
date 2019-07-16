package org.yabo.spring.test.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class Service implements BeanPostProcessor, InitializingBean {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization--》》》" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization--》》》" + beanName);
        return bean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
