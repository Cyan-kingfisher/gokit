package org.example.mall.config;

import com.obs.services.ObsClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cyan
 * @since 2022/4/13
 */
@Slf4j
@Configuration
public class ObsStorageConfig {

    @Value("${huawei.obs.accessKeyId}")
    private String accessKeyId;

    @Value("${huawei.obs.secretAccessKey}")
    private String secretAccessKey;

    @Value("${huawei.obs.endPoint}")
    private String endPoint;

    @Bean
    public ObsClient obsClient() {
        return new ObsClient(accessKeyId, secretAccessKey, endPoint);
    }

}
