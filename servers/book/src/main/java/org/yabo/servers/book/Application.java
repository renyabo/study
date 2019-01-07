package org.yabo.servers.book;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ImportResource("classpath:dubbo.xml")
@PropertySource("classpath:application.properties")
public class Application implements CommandLineRunner {

    @Value("${log.root.path}")
    String path;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(path);
        Thread thread = Thread.currentThread();
        System.out.println(thread.toString());
        thread.join();
    }
}
