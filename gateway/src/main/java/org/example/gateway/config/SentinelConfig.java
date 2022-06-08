package org.example.gateway.config;

import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.SentinelGatewayFilter;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.exception.SentinelGatewayBlockExceptionHandler;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.view.ViewResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * @author cyan
 * @since 2022/5/31
 */
@Configuration
public class SentinelConfig {

    private final List<ViewResolver> viewResolvers;

    private final ServerCodecConfigurer serverCodecConfigurer;

    public SentinelConfig(List<ViewResolver> viewResolvers, ServerCodecConfigurer serverCodecConfigurer) {
        this.viewResolvers = viewResolvers;
        this.serverCodecConfigurer = serverCodecConfigurer;
    }

//    @Bean
//    @Order(Ordered.HIGHEST_PRECEDENCE)
//    public GlobalFilter sentinelGatewayFilter() {
//        return new SentinelGatewayFilter();
//    }

    // 配置初始化的限流参数
//    @PostConstruct
//    public void initGatewayRules() {
//        Set<GatewayFlowRule> rules = new HashSet<>();
//
//        //分别给指定的资源 配置限流
//        //  GatewayFlowRule 资源名称,对应路由id     setCount  限流阈值   setIntervalSec 统计时间窗口，单位是秒，默认是 1 秒
//        //简单来说就是     如果Count=1    IntervalSec=1  那么一秒钟只允许访问一次   (用于测试)
//        // 如果Count=5    IntervalSec=2  那么2秒钟只允许访问5次   (用于测试)
//        // 如果Count=60   IntervalSec=3  那么3秒钟只允许访问60次 也就是1秒20次  一般用于生产(一般够了)
//        // 如果是商城网站那么Count和IntervalSec 这个需要计算平均每天每秒最大的请求量是多少然后在设置
//        int count=1;
//        int intervalSec=1;
//
//        //设置指定路由的限流
//        rules.add(new GatewayFlowRule("api-mall").setCount(1).setIntervalSec(1));
//        rules.add(new GatewayFlowRule("api-usve").setCount(1).setIntervalSec(1));
//        GatewayRuleManager.loadRules(rules);
//
//    }

    // 配置限流的异常处理器
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SentinelGatewayBlockExceptionHandler sentinelGatewayBlockExceptionHandler() {
        return new SentinelGatewayBlockExceptionHandler(viewResolvers, serverCodecConfigurer);
    }

    //　自定义限流异常页面
    @PostConstruct
    public void initBlockHandlers() {
        BlockRequestHandler blockRequestHandler = new BlockRequestHandler() {
            @Override
            public Mono<ServerResponse> handleRequest(ServerWebExchange serverWebExchange, Throwable throwable) {
                Map map = new HashMap<>();
                map.put("code", 20889);
                map.put("message", "接口限流");
                return ServerResponse.status(HttpStatus.OK).
                        contentType(MediaType.APPLICATION_JSON).
                        bodyValue(map);
            }
        };
        GatewayCallbackManager.setBlockHandler(blockRequestHandler);
    }


}

