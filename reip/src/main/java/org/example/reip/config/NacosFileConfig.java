package org.example.reip.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author cyan
 * @since 2022/4/9
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Configuration
public class NacosFileConfig {

    @Value("${config.info.nacos-timeout}")
    private long DEFAULT_TIMEOUT;

    @Value("${config.info.nacos-address}")
    private String NACOS_SERVER_ADDR;

    @Value("${config.info.nacos-namespace}")
    private String NACOS_NAMESPACE;

    @Value("${config.info.nacos-data-id}")
    private String NACOS_ROUTE_DATA_ID;

    @Value("${config.info.nacos-group}")
    private String NACOS_ROUTE_GROUP;

}
