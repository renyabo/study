package org.yabo.aop.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yabo.service.test.AopInterface;

import java.util.List;

@Controller
@ResponseBody
public class AopController {

    @Autowired
    List<AopInterface> aopInterfaces;

    @RequestMapping("/aop")
    public String aop(int i) {
        AopInterface aopInterface = aopInterfaces.get(i);
        return aopInterface.aop();
    }
}
