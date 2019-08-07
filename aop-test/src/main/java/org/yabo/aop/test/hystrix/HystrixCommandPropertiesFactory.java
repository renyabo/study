package org.yabo.aop.test.hystrix;

import com.netflix.hystrix.HystrixCommandProperties;

/**
 * 命令相关配置
 */
public class HystrixCommandPropertiesFactory {

    public static HystrixCommandProperties.Setter create() {
        return HystrixCommandProperties.Setter().withCircuitBreakerSleepWindowInMilliseconds(5000)
                .withCircuitBreakerErrorThresholdPercentage(50)
                .withCircuitBreakerRequestVolumeThreshold(20)
                .withExecutionIsolationThreadInterruptOnTimeout(true)
                .withExecutionTimeoutInMilliseconds(1000)
                .withFallbackIsolationSemaphoreMaxConcurrentRequests(50)
                .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
                .withExecutionIsolationSemaphoreMaxConcurrentRequests(10);

    }
}
