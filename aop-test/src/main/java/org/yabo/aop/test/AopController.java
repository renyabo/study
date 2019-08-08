package org.yabo.aop.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yabo.service.book.BookChildService;
import org.yabo.service.test.AopInterface;

@Controller
@ResponseBody
public class AopController {

    @Autowired
    AopInterface aopInterface;
    @Autowired
    BookChildService bookChildService;

    @RequestMapping("/test")
    public String aop() {
        return aopInterface.aop() + "---" + aopInterface.aop1() + "---" + aopInterface.aop2() + "-----" + bookChildService.getBook("test").getData().getName();
    }
}
