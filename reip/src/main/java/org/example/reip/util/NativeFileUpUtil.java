package org.example.reip.util;

import lombok.extern.slf4j.Slf4j;
import org.example.reip.config.FileInfo;
import org.example.reip.config.FileUpConfig;
import org.example.reip.service.FileUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * @author cyan
 * @since 2022/7/23
 */
@Slf4j
@Service
public class NativeFileUpUtil implements FileUpService {

    @Autowired
    public FileInfo fileInfo;
    
    @Override
    public String getImage(MultipartFile file) {
        log.info("thread-name: " + Thread.currentThread().getName());

        String oriName = String.valueOf(Objects.requireNonNull(file.getOriginalFilename()));
        log.info("origin name: {}, houzhui: {}", oriName, oriName.substring(oriName.lastIndexOf('.')));
        String savePath = oriName;
        File fileIO = new File(fileInfo.getFilePath() + savePath + "/");

        if (!fileIO.exists()) {
            boolean flag = fileIO.mkdirs();
        }

        try {
            file.transferTo(fileIO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = fileInfo.getLocal() + fileInfo.getUrl() + savePath;
        log.info("url: " + result);
        return result;

    }
}
