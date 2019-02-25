package org.yabo.servers.test;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
@ImportResource("classpath:dubbo.xml")
@PropertySource("classpath:application.properties")
public class Application {

    private static final Logger LOGGER = Logger.getLogger(Application.class);
    JpaRepository jpaRepository;

    public static void main(String[] args) {
        LOGGER.debug("start..");
        SpringApplication.run(Application.class, args);
        LOGGER.debug("end..");
    }
}
