package org.yabo.repository;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.yabo.repository.aspect.CheckEntityAspect;

import javax.sql.DataSource;

@Configuration
@MapperScan("org.yabo.repository.mapper")
public class DBConfig {

    private static final Logger LOGGER = Logger.getLogger(DBConfig.class);

    //连接数据库
    @Bean("dataSource")
    public DataSource getDataSource(@Value("${db.driver}") String driver,
                                    @Value("${db.url}") String url,
                                    @Value("${db.username}") String userName,
                                    @Value("${db.password}") String password) {
        System.out.println(String.format("*****properties,driver=%s.url=%s,name=%s,pwd=%s****", driver, url, userName, password));
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean("configuration")
    public org.apache.ibatis.session.Configuration getConfiguration() {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setUseGeneratedKeys(true);
        configuration.setCacheEnabled(false);
        configuration.setLogImpl(Log4j2Impl.class);
        return configuration;
    }

    @Bean(name = "mysqlSessionFactory")
    @DependsOn({"dataSource", "configuration"})
    public SqlSessionFactoryBean getSqlSessionFactory(@Qualifier("dataSource") DataSource dataSource,
                                                      @Qualifier("configuration") org.apache.ibatis.session.Configuration configuration) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setConfiguration(configuration);
        bean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(DBConfig.class.getClassLoader());
        Resource resource = resolver.getResource("classpath:/mapper/UserMapper.xml");
        bean.setMapperLocations(new Resource[]{resource});
        return bean;
    }

    @Bean
    public PlatformTransactionManager getDataSourceTransactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public CheckEntityAspect checkEntityAspect(){
        return new CheckEntityAspect();
    }
}
