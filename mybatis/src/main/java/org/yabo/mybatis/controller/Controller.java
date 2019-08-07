package org.yabo.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yabo.common.beans.User;
import org.yabo.mybatis.mapper.UserMapper;

@RestController
public class Controller {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/insert")
    public String insert() {
        User user = new User();
        user.setId(System.currentTimeMillis());
        user.setDescription("user");
        user.setUserName("test");
        userMapper.insert(user);
        return "OK";
    }
}
