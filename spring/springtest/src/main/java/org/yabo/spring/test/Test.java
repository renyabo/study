package org.yabo.spring.test;

import com.alibaba.fastjson.JSON;
import org.yabo.common.util.TaskManager;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Test {

    public static void main(String[] args) {
//        TaskManager taskManager = new TaskManager("Yabo");
//        for (int i = 0; i < 100000; i++) {
//            System.out.println(i);
//            taskManager.getExecutor().execute(() -> System.out.println(Thread.currentThread()));
//        }
//        System.out.println("over");
        String json="[{\"a\":1},{\"b\":2}]";
        System.out.println(json);
        Object parse = JSON.parse(json);
        System.out.println(parse.getClass());
    }
}
