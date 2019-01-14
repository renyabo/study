package org.yabo.gateway.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yabo.common.Response;
import org.yabo.common.Result;
import org.yabo.service.test.TestService;

import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping("/testCH")
    public Response testCH() {
        System.out.println("call in,thread=" + Thread.currentThread().toString());
        Map<String, Object> map = new HashMap<>();
//        map.put("原始", Thread.currentThread());
        Map<String,Object> m = new HashMap<>();
        m.put("你好","你不会");
        m.put("你好1","你不会1");
        m.put("你好2","你不会2");
        map.put("转换", m);
        map.put("a","b");
        Response response = new Response();
        response.setCode(200);
        response.setMessage("success");
        response.setData(map);
        return response;
    }

}
