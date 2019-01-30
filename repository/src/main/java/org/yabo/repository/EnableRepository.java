package org.yabo.repository;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import java.lang.annotation.*;

/**
 * 启用db操作
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@PropertySource("classpath:db.properties")
@Import(DBConfig.class)
public @interface EnableRepository {
}
