package org.yabo.filter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.yabo.filter");
        FilterManager bean = context.getBean(FilterManager.class);
        bean.test();
        Filter bean1 = context.getBean("myFilter",Filter.class);
        System.out.println(bean1==null);

        S1 s1 = context.getBean(S1.class);
        s1.test();
        S2 s2 = context.getBean(S2.class);
        s2.test();
    }
}
