package org.yabo.repository;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
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
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(getClass().getClassLoader());
        Resource resource = resolver.getResource("classpath:db.properties");
        System.out.println(resource);
        configurer.setLocations(resource);
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
//        db.driver=com.mysql.cj.jdbc.Driver
//        db.url=jdbc:mysql://172.16.61.128:3306/yabo?useUnicode=true&amp;characterEncoding=utf-8
//        db.username=root
//        db.password=123456
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://172.16.61.128:3306/yabo?useUnicode=true&characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean
    public org.apache.ibatis.session.Configuration getConfiguration() {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setUseGeneratedKeys(true);
        configuration.setCacheEnabled(false);
        configuration.setLogImpl(Log4j2Impl.class);
        return configuration;
    }

    @Bean
    public MapperScannerConfigurer getMapperScanner(@Autowired SqlSessionFactoryBean sqlSessionFactoryBean) {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("org.yabo.repository.mapper");
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return configurer;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean getSqlSessionFactory(@Autowired DataSource dataSource,
                                                      @Autowired org.apache.ibatis.session.Configuration configuration) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setConfiguration(configuration);
        bean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(getClass().getClassLoader());
        Resource resource = resolver.getResource("classpath:/mapper/UserMapper.xml");
        bean.setMapperLocations(new Resource[]{resource});
        return bean;
    }

    @Bean
    public PlatformTransactionManager getDataSourceTransactionManager(@Autowired DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
