package org.example.reip.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author cyan
 * @since 2022/7/24
 */
public interface FileUpService {

    public CompletableFuture<String> getImage(MultipartFile file);

}