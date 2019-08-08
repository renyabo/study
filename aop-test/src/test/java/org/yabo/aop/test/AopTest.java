package org.yabo.aop.test;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AopTest {

    @Test
    public void test1() throws IOException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 2000; i++) {
            executorService.submit(() -> {
                RestTemplate template = new RestTemplate();
                System.out.println(template.getForObject("http://localhost:8082/test", String.class));
            });
            Thread.sleep(100L);
        }
    }
}
