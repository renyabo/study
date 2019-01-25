package org.yabo.spring.cache;

import org.springframework.context.annotation.Import;
import org.yabo.spring.cache.service.UserService;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(UserService.class)
@Documented
public @interface EnableUserService {
}
