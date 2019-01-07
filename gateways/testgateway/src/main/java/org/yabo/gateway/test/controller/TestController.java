package org.yabo.gateway.test.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yabo.common.Result;
import org.yabo.service.test.TestService;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/test")
    public String test() {
        System.out.println("call in,thread=" + Thread.currentThread().toString());
        Result<String> test = testService.test(Thread.currentThread().toString());
        return test.getData();
    }
}
