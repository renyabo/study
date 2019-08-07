package org.yabo.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan("org.yabo.mybatis.mapper")
@PropertySource("classpath:db.properties")
public class DBConfig2 {

    private static final Logger LOGGER = Logger.getLogger(DBConfig2.class);

    //连接数据库
    @Bean("dataSource2")
    public DataSource getDataSource(@Value("${db.driver}") String driver,
                                    @Value("${db.url}") String url,
                                    @Value("${db.username}") String userName,
                                    @Value("${db.password}") String password) {
        System.out.println(String.format("*****2222,driver=%s.url=%s,name=%s,pwd=%s****", driver, url, userName, password));
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean("configuration2")
    public org.apache.ibatis.session.Configuration getConfiguration() {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setUseGeneratedKeys(true);
        configuration.setCacheEnabled(false);
        configuration.setLogImpl(Log4j2Impl.class);
        return configuration;
    }

    @Bean(name = "mysqlSessionFactory2")
    @DependsOn({"dataSource2", "configuration2"})
    public SqlSessionFactoryBean getSqlSessionFactory(@Qualifier("dataSource2") DataSource dataSource,
                                                      @Qualifier("configuration2") org.apache.ibatis.session.Configuration configuration) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setConfiguration(configuration);
        bean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(DBConfig2.class.getClassLoader());
        Resource resource = resolver.getResource("classpath:/mapper/UserMapper.xml");
        bean.setMapperLocations(new Resource[]{resource});
        return bean;
    }

    @Bean("tm2")
    public PlatformTransactionManager getDataSourceTransactionManager(@Qualifier("dataSource2") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
