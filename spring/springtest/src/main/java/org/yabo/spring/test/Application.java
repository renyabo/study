package org.yabo.spring.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.yabo.repository.EnableRepository;
import org.yabo.yache.CacheConfiguration;

@SpringBootApplication
@EnableRepository
@ServletComponentScan
@EnableAspectJAutoProxy
@Import(CacheConfiguration.class)
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class);
        System.out.println(run);
    }
}

