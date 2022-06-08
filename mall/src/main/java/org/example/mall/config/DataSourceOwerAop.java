package org.example.mall.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.example.mall.annotation.SelectDataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @author cyan
 * @since 2022/4/17
 */
@Configuration
@Aspect
@Order(2)
@Slf4j
public class DataSourceOwerAop {

    @Before("@annotation(dataSource)")
    public void setDataSource(JoinPoint point, SelectDataSource dataSource) {
        log.info("DB SWITCH: "+dataSource.value().getMsg());
        DataSourceType.setDataBaseType(dataSource.value());
    }

    @After("@annotation(dataSource)")
    public void clearDataSource(JoinPoint point, SelectDataSource dataSource) {
        log.info("DB SWITCH: "+dataSource.value().getMsg());
        DataSourceType.clearDataBaseType();
    }

}
