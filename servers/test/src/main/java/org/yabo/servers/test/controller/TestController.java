package org.yabo.servers.test.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yabo.common.Result;
import org.yabo.service.test.TestService;

@RestController
public class TestController {

    private static final Logger LOGGER = Logger.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public String test() {
        LOGGER.error("test...");
        Result<String> test = testService.test(Thread.currentThread().toString());
        System.out.println("in test...");
        return test.getData();
    }

    public static void main(String[] args) {
        System.out.println(System.getProperties());
    }
}
