package org.yabo.aop1;

import org.springframework.stereotype.Service;
import org.yabo.service.test.AopInterface;

@Service("aopService")
public class AopService implements AopInterface {
    @Override
    public String aop() {
        return "aop1";
    }

    @Override
    public String aop1() {
        return "aop1";
    }

    @Override
    public String aop2() {
        return "aop1";
    }

    @Override
    public String name() {
        return AopService.class.getName();
    }
}
