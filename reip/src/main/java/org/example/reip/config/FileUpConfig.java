package org.example.reip.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @author cyan
 * @since 2022/4/9
 */
@Slf4j
@Component
public class FileUpConfig {

    @Autowired
    private NacosFileConfig config;

    private ConfigService configService;

    @Autowired
    public FileInfo fileInfo;

    FileInfo tic = null;

    @PostConstruct
    public void init() {
        log.info("file up init...");
        try {
            configService = initConfigService();
            if (configService == null) {
                log.warn("initConfigService fail");
                return;
            }
            String configInfo = configService.getConfig(config.getNACOS_ROUTE_DATA_ID(), config.getNACOS_ROUTE_GROUP(), config.getDEFAULT_TIMEOUT());
            log.info("获取文件上传当前配置:\r\n{}", configInfo);
            tic = JSON.parseObject(configInfo, FileInfo.class);
            fileInfo.init(tic);
        } catch (Exception e) {
            log.error("初始化文件上传参数发生错误", e);
        }

        FileUploadByNacosListener(config.getNACOS_ROUTE_DATA_ID(), config.getNACOS_ROUTE_GROUP());


    }

    /**
     * 监听Nacos下发的文件上传配置
     *
     * @param dataId
     * @param group
     */
    public void FileUploadByNacosListener(String dataId, String group) {
        try {
            configService.addListener(dataId, group, new Listener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    log.info("进行文件上传配置更新:\n\r{}", configInfo);
                    fileInfo.init(JSON.parseObject(configInfo, FileInfo.class));
                    log.info("fileInfo : {}", fileInfo);
                }

                @Override
                public Executor getExecutor() {
                    log.info("getExecutor\n\r");
                    return null;
                }
            });
        } catch (NacosException e) {
            log.error("从nacos接收文件上传参数出错!!!", e);
        }
    }

    /**
     * 初始化文件上传参数由 nacos config
     *
     * @return
     */
    private ConfigService initConfigService() {
        try {
            Properties properties = new Properties();
            properties.setProperty("serverAddr", config.getNACOS_SERVER_ADDR());
            properties.setProperty("namespace", config.getNACOS_NAMESPACE());
            return configService = NacosFactory.createConfigService(properties);
        } catch (Exception e) {
            log.error("初始化文件上传参数发生错误", e);
            return null;
        }
    }


}
