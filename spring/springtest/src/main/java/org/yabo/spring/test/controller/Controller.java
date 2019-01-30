package org.yabo.spring.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yabo.common.Response;
import org.yabo.common.beans.User;
import org.yabo.common.util.TaskManager;
import org.yabo.repository.mapper.UserMapper;

@RestController
public class Controller {

    UserMapper userMapper;
    TaskManager taskManager;

    public Controller(@Autowired UserMapper userMapper,
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

    @RequestMapping("/deathLock")
    public Response deathLock() {
        Response response = new Response();
        doDeathLock();
        response.setData("deathLock");
        return response;
    }

    private void doDeathLock() {
        taskManager.getExecutor().execute(() -> {
            synchronized (Controller.class) {
                System.out.println("lock...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
