package org.yabo.aop.test.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogisticsCommand extends HystrixCommand<Object> {

    ProceedingJoinPoint joinPoint;

    public LogisticsCommand(Setter setter, ProceedingJoinPoint joinPoint) {
        super(setter);
        this.joinPoint = joinPoint;
    }

    @Override
    protected Object run() {
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            System.err.println(throwable.getMessage());
            throw new HystrixRuntimeException(HystrixRuntimeException.FailureType.COMMAND_EXCEPTION, LogisticsCommand.class, throwable.getMessage(), throwable, null);
        }
    }

    @Override
    protected Object getFallback() {
        return "fallback";
    }
}
