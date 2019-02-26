package org.yabo.common.anno;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CheckEntity {
    String message() default "Check entity msg";

    String key() default "#id";
}
