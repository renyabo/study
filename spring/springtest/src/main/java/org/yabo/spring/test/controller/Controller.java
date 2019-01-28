package org.yabo.spring.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yabo.common.Response;
import org.yabo.common.beans.User;
import org.yabo.repository.mapper.UserMapper;

@RestController
public class Controller {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/test")
    public Response test() {
        Response response = new Response();
        User user = new User();
        user.setUserName("repo");
        user.setDescription("desc");
        response.setData(userMapper.insert(user));
        return response;
    }
}
