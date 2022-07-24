package org.example.reip.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author cyan
 * @since 2022/7/23
 */
@Slf4j
@Configuration
public class ResourceHandlersConfiguration implements WebMvcConfigurer {

    @Autowired
    private FileInfo fileInfo;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.error("-------------------------------------------");
        log.error("                    ----");
        log.error("                    ----");
        log.error("                    ----");
        log.error("                    ----");
        log.error("                    ----");
        log.error("                    ----");
        log.error("                    ----");
        log.error("                    ----");
        log.info("FILE_INFO: {}", fileInfo);
        log.error("                    ----");
        log.error("                    ----");
        log.error("                    ----");
        log.error("                    ----");
        log.error("                    ----");
        log.error("                    ----");
        log.error("                    ----");
        log.error("-------------------------------------------");
        registry.addResourceHandler(fileInfo.getUrl() + "**")
                .addResourceLocations("file:" + fileInfo.getFilePath());
    }
}
