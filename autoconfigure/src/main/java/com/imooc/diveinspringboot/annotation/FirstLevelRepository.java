package com.imooc.diveinspringboot.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * @Component 注解可传递 相应的配置参数也可传递
 * 一级 {@link Repository @Repository}
 *
 * @author 小马哥
 * @since 2018/5/14
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repository
public @interface FirstLevelRepository {

    String value() default "";

}
