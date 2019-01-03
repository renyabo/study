package org.yabo.servers.test;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@SpringBootConfiguration
@ImportResource("classpath:dubbo.xml")
public class Application {

    private static final Logger LOGGER = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        LOGGER.debug("start..");
        SpringApplication.run(Application.class, args);
        LOGGER.debug("end..");
    }
}
