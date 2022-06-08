package org.example.reip.annotation;

import org.example.reip.config.DataSourceType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author cyan
 * @since 2022/4/17
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.PARAMETER})
public @interface SelectDataSource {
    DataSourceType.Type value() default DataSourceType.Type.MASTER;
}
