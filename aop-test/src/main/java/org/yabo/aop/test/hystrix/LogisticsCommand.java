package org.yabo.aop.test.hystrix;

import com.netflix.hystrix.HystrixCommand;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogisticsCommand extends HystrixCommand<Object> {

    ProceedingJoinPoint joinPoint;

    public LogisticsCommand(Setter setter, ProceedingJoinPoint joinPoint) {
        super(setter);
        this.joinPoint = joinPoint;
    }

    @Override
    protected Object run() throws Exception {
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            System.err.println(throwable.getMessage());
            throw new Exception(throwable.getMessage());
        }
    }
}
