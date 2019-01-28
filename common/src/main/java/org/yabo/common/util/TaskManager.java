package org.yabo.common.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskManager {
    private int count;
    private String name = null;
    private ExecutorService executor = null;

    public TaskManager() {
        this("taskManager", Runtime.getRuntime().availableProcessors() * 2);
    }

    public TaskManager(String name) {
        this(name, Runtime.getRuntime().availableProcessors() * 2);
    }

    public TaskManager(int threads) {
        this("taskManager", threads);
    }

    public TaskManager(String name, int threads) {
        this.name = name;
        this.count = threads;
        this.executor = Executors.newFixedThreadPool(threads, r -> new Thread(r, this.name + this.count++));
    }

    public ExecutorService getExecutor() {
        return executor;
    }
}
