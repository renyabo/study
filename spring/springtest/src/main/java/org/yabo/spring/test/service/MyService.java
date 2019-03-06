package org.yabo.spring.test.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.yabo.common.anno.CheckEntity;
import org.yabo.common.beans.Company;

@Service
public class MyService {
    @CheckEntity(key = "#compay.id")
    public void serviceMethod1(String name, Long id, Company compay) {
        System.err.println("id: " + id + " ,name: " + name);
    }

    @Cacheable(value = "myService", key = "#id", condition = "@yabo.check()")
    public String condition(Long id) {
        return "OK";
    }
}
