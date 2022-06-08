package org.example.mall.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @author cyan
 * @since 2022/4/17
 */
@Aspect
@Configuration
@Order(0)
@Slf4j
public class DataSourceAop {

    @Pointcut("execution( * org.example.mall.service..*.select*(..))"
    + "|| execution( * org.example.mall.service..*.equals*(..))"
    + "|| execution( * org.example.mall.service..*.exist*(..))")
    public void readPointCut() {

    }

    @Pointcut("execution( * org.example.mall.service..*.insert*(..))"
            + "|| execution( * org.example.mall.service..*.delete*(..))"
            + "|| execution( * org.example.mall.service..*.update*(..))")
    public void writePointCut() {}

    @Before("readPointCut()")
    public void read() {
        log.info("DB SWITCH: "+DataSourceType.Type.SLAVE.getMsg());
        DataSourceType.setDataBaseType(DataSourceType.Type.SLAVE);
    }

    @Before("writePointCut()")
    public void write() {
        log.info("DB SWITCH: "+DataSourceType.Type.MASTER.getMsg());
        DataSourceType.setDataBaseType(DataSourceType.Type.MASTER);
    }


}
