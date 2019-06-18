package org.yabo.spring.cache;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.yabo.spring.cache.service.DynamicService;
import org.yabo.spring.cache.service.TestService;

public class SpringLearningTest {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-test.xml");
        TestService bean = context.getBean(TestService.class);
        System.out.println(bean);
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        System.out.println(beanFactory.getClass());
        beanFactory.registerSingleton("dynamic",new DynamicService());
        DynamicService bean1 = context.getBean(DynamicService.class);
        System.out.println(bean1);
    }
}
