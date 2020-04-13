package cn.piao888.dynamic.annotation;

import cn.piao888.dynamic.enums.DataSourceType;

import java.lang.annotation.*;
/**
 * 数据源注解
 * @author seven
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface DS {
    DataSourceType value() default  DataSourceType.MASTER;
}