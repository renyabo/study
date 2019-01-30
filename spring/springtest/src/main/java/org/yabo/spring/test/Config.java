package org.yabo.spring.test;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class Config {

//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//        System.out.println("构建properties place holder....");
//        return new PropertySourcesPlaceholderConfigurer();
//    }

//    @Bean
//    public PropertyPlaceholderConfigurer robotPlaceholderConfigurer() {
//        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
//        configurer.setIgnoreUnresolvablePlaceholders(true);
//        configurer.setSearchSystemEnvironment(true);
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(getClass().getClassLoader());
//        Resource resource = resolver.getResource("classpath:db.properties");
//        System.out.println(resource);
//        configurer.setLocations(resource);
//        configurer.setLocalOverride(true);
//        System.out.println("repository placeholder configurer started");
//        return configurer;
//    }
}
