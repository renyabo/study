package org.yabo.aop.test.aop;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.yabo.aop.test.hystrix.HystrixCommandPropertiesFactory;
import org.yabo.aop.test.hystrix.HystrixThreadPoolPropertiesFactory;
import org.yabo.aop.test.hystrix.LogisticsCommand;

@Aspect
@Component
public class AopAspect {

    @Pointcut("execution(* org.yabo.service.test.AopInterface.*(..))")
    public void aop() {
    }

    @Around("aop()")
    public Object aopAround(ProceedingJoinPoint joinPoint) {
//        AopInterface aopInterface = (AopInterface) joinPoint.getTarget();
//        System.out.println(String.format("%s_%s_%s", aopInterface.getClass().getName(), joinPoint.getSignature().getName(), aopInterface.name()));
        System.out.println(joinPoint.getSignature().getName());
        HystrixCommand.Setter setter = HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(joinPoint.getSignature().getName()))
                .andCommandKey(HystrixCommandKey.Factory.asKey(joinPoint.getSignature().getName()))
                .andCommandPropertiesDefaults(HystrixCommandPropertiesFactory.create())
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolPropertiesFactory.create());
        return new LogisticsCommand(setter,joinPoint).execute();
    }
}
