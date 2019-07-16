package org.yabo.spring.test;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Component
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.err.println("load context,sce="+ sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.err.println("destroy context,sce="+ sce);
    }
}
