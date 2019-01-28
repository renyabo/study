package org.yabo.repository;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

    private static final Logger LOGGER = Logger.getLogger(DBConfig.class);

    @Bean
    public PropertyPlaceholderConfigurer robotPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setIgnoreUnresolvablePlaceholders(true);
        configurer.setSearchSystemEnvironment(true);
        configurer.setLocations(new ClassPathResource("classpath:db.properties"));
        configurer.setLocalOverride(true);
        LOGGER.info("repository placeholder configurer started");
        return configurer;
    }

    //连接数据库
    @Bean
    public DataSource getDataSource(@Value("${db.driver}") String driver,
                                    @Value("${db.url}") String url,
                                    @Value("${db.username}") String userName,
                                    @Value("${db.password}") String password) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean getSqlSessionFactory(@Autowired DataSource dataSource) {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setUseGeneratedKeys(true);
        configuration.setCacheEnabled(false);
        configuration.setLogImpl(Log4j2Impl.class);
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setConfiguration(configuration);
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new Resource[]{new ClassPathResource("classpath:mapper")});
        return bean;
    }

    @Bean
    public PlatformTransactionManager getDataSourceTransactionManager(@Autowired DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
