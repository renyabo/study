package org.yabo.aop.test;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class AopTest {

    @Test
    public void test1() {
        RestTemplate template = new RestTemplate();
        System.out.println(template.getForObject("http://localhost:8080/aop?i=1", String.class));
        for (int i = 0; i < 2000; i++) {
            System.out.println(template.getForObject("http://localhost:8080/aop?i=" + i % 2, String.class));
        }
    }
}
