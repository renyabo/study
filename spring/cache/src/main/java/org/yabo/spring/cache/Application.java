package org.yabo.spring.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.yabo.spring.cache.service.UserService;

@SpringBootApplication
@EnableUserService
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        UserService bean = context.getBean(UserService.class);
        bean.test();
    }
}
