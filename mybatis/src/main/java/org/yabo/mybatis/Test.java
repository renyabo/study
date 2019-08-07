package org.yabo.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DBConfig.class/*, DBConfig2.class*/);
        for (String name : applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        SqlSession bean = applicationContext.getBean(SqlSession.class);
//        UserMapper bean = applicationContext.getBean(UserMapper.class);
        System.out.println(bean);
//        bean = applicationContext.getBean(UserMapper.class);
//        System.out.println(bean);
//        bean = applicationContext.getBean(UserMapper.class);
//        System.out.println(bean);
//        bean = applicationContext.getBean(UserMapper.class);
//        System.out.println(bean);
//        bean = applicationContext.getBean(UserMapper.class);
//        System.out.println(bean);
//
//        SqlSessionFactory sqlSessionFactory = applicationContext.getBean(SqlSessionFactory.class);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        System.out.println(mapper);

//        User user = new User();
//        user.setId(System.currentTimeMillis());
//        user.setUserName("test");
//        user.setDescription("test");
//        int insert = bean.insert(user);
//        System.out.println(insert);
    }
}
