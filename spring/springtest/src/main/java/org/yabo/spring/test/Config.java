package org.yabo.spring.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.yabo.repository.DBConfig;

@Configuration
@Import(DBConfig.class)
public class Config {
}
