package org.yabo.spring.test.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.yabo.spring.test.service.MyService;

@Component("MySpringBean")
public class MySpringBean implements BeanNameAware, BeanFactoryAware, InitializingBean, ApplicationContextAware, BeanPostProcessor {

    private ApplicationContext applicationContext;

    @Autowired
    private MyService myService;

    private static final Logger logger = LoggerFactory.getLogger(MySpringBean.class);


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("postProcessBeforeInitialization......" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("postProcessAfterInitialization......" + beanName);
        return bean;
    }

    public MySpringBean() {
        logger.info("new MySpringBean......");
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        logger.info("ApplicationContextAware-setApplicationContext......");
        this.applicationContext = context;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("InitializingBean-afterPropertiesSet......");
    }

    @Override
    public void setBeanFactory(BeanFactory bf) throws BeansException {
        logger.info("BeanFactoryAware-setBeanFactory......");
    }

    @Override
    public void setBeanName(String name) {
        logger.info("BeanNameAware-setBeanName......");
    }

    public void init() {
        logger.info("init-method......");
    }
}