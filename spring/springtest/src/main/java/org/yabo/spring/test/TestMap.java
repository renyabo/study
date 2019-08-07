package org.yabo.spring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.yabo.spring.test.service.MapService;

public class TestMap {

    public static void main(String[] args) {
//        TaskManager taskManager = new TaskManager("Yabo");
//        for (int i = 0; i < 100000; i++) {
//            System.out.println(i);
//            taskManager.getExecutor().execute(() -> System.out.println(Thread.currentThread()));
//        }
//        System.out.println("over");
//        String json="[{\"a\":1},{\"b\":2}]";
//        System.out.println(json);
//        Object parse = JSON.parse(json);
//        System.out.println(parse.getClass());

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/beans.xml");
        MapService bean = applicationContext.getBean(MapService.class);
        System.out.println(bean.getMap());
    }
}
