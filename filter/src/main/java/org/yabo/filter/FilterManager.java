package org.yabo.filter;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class FilterManager implements ApplicationContextAware, ApplicationEventPublisher, ApplicationEventPublisherAware {

    List<Filter> filters;
    ApplicationContext applicationContext;
    @Autowired
    @Qualifier("myFilter")
    Filter filter;

    public FilterManager() {
        System.out.println("FilterManager..."+Thread.currentThread());
    }

    @Autowired
    public void setFilters(List<Filter> filters) {
        System.out.println("set list");
        this.filters = filters;
    }

    public void test() {
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Filter.class);
        System.out.println(Arrays.toString(beanNamesForType));
        System.out.println(filter.getClass());
//        if (CollectionUtils.isNotEmpty(filters)) {
//            for (Filter filter : filters) {
//                System.out.println(filter.getClass());
//            }
//        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext");
        this.applicationContext = applicationContext;
    }


    @Override
    public void publishEvent(Object event) {
        System.out.println("publishEvent="+event);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("setApplicationEventPublisher");
    }
}
