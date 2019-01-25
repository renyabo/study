package org.yabo.spring.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yabo.common.Response;
import org.yabo.common.beans.User;
import org.yabo.spring.cache.dao.UserDAO;
import org.yabo.spring.cache.service.UserService;

@RestController
public class CacheController {

    private static long idGen = 10;

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/test")
    public Response test() {
        Response response = new Response();
        response.setCode(200);
        response.setData("OK");
        response.setMessage("success");
        return response;
    }

    @RequestMapping("/insert")
    public Response insert() {
        Response response = new Response();
        response.setCode(200);
        User user = new User();
        user.setId(idGen++);
        user.setDescription("yabo");
        user.setUser_name("yabo");
        response.setData(userDAO.insert(user));
        response.setMessage("success");
        return response;
    }

    @RequestMapping("/query")
    public Response query(@RequestParam("id") Long id) {
        Response response = new Response();
        response.setCode(200);
        System.out.println("id=" + id);
        response.setData(userDAO.queryById(id));
        response.setMessage("success");
        return response;
    }

    @RequestMapping("/update")
    public Response query(@RequestParam("id") Long id,
                          @RequestParam("userName") String userName) {
        Response response = new Response();
        response.setCode(200);
        System.out.println("id=" + id);
        System.out.println("userName=" + userName);
        response.setData(userDAO.update(id, userName));
        response.setMessage("success");
        return response;
    }

    @RequestMapping("/delete")
    public Response delete(@RequestParam("id") Long id) {
        Response response = new Response();
        response.setCode(200);
        System.out.println("id=" + id);
        response.setData(userDAO.deleteById(id));
        response.setMessage("success");
        return response;
    }
}
