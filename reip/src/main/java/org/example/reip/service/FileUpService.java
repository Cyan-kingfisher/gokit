package org.example.reip.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author cyan
 * @since 2022/7/23
 */
public interface FileUpService {

    public String getImage(MultipartFile file);

}
