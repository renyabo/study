package org.yabo.aop.test;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.yabo.service.test.AopInterface;

@Service
public class AopService1 implements AopInterface {

    static RestTemplate restTemplate = new RestTemplate();

    @Override
    public String aop() {
        return "AopService1:aop" + restTemplate.getForObject("http://www.baidu.com", String.class);
    }

    @Override
    public String aop1() {
        return "AopService1:aop1" + restTemplate.getForObject("http://www.baidu.com", String.class);
    }

    @Override
    public String aop2() {
        return "AopService1:aop2" + restTemplate.getForObject("http://www.baidu.com", String.class);

    }

    @Override
    public String name() {
        return "AopService1";
    }

    public static void main(String[] args) {
        System.out.println(restTemplate.getForObject("http://www.baidu.com", String.class));
    }
}
