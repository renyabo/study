package org.yabo.aop.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAspectJAutoProxy
@ImportResource("classpath:dubbo.xml")
@PropertySource("classpath:application.properties")
public class AopApplication {
    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class);
    }
}
