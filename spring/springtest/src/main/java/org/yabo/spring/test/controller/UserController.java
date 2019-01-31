package org.yabo.spring.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yabo.common.Response;
import org.yabo.common.beans.User;
import org.yabo.common.util.TaskManager;
import org.yabo.repository.mapper.UserMapper;

import java.util.List;

@RestController
public class UserController {

    UserMapper userMapper;
    TaskManager taskManager;

    public UserController(@Autowired UserMapper userMapper,
                          @Autowired TaskManager taskManager) {
        this.userMapper = userMapper;
        this.taskManager = taskManager;
    }

    @RequestMapping("/test")
    public Response test() {
        Response response = new Response();
        User user = new User();
        user.setUserName("repo");
        user.setDescription("desc");
        response.setData(userMapper.insert(user));
        return response;
    }

    @RequestMapping("/list")
    public Response list() {
        Response response = new Response();
        List<User> query = userMapper.query();
        response.setMessage("SUCCESS");
        response.setData(query);
        return response;
    }

    @RequestMapping("/deathLock")
    public Response deathLock() {
        Response response = new Response();
        doDeathLock();
        response.setData("deathLock");
        return response;
    }

    private void doDeathLock() {
        taskManager.getExecutor().execute(() -> {
            synchronized (UserController.class) {
                while (true) {
                    System.out.println("lock..." + Thread.currentThread());
                }
            }
        });
    }
}