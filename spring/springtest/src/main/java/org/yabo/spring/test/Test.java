package org.yabo.spring.test;

import org.yabo.common.util.TaskManager;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Test {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager("Yabo");
        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
            taskManager.getExecutor().execute(() -> System.out.println(Thread.currentThread()));
        }
        System.out.println("over");
    }
}
