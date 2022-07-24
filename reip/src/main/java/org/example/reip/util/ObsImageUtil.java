package org.example.reip.util;

import com.obs.services.ObsClient;
import com.obs.services.model.AccessControlList;
import com.obs.services.model.PutObjectRequest;
import org.example.reip.service.FileUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * @author cyan
 * @since 2022/4/14
 */
@Component
public class ObsImageUtil implements FileUpService {

    private static final String bucket = "gokit";
    private static final int expire = 1665423265;
    private static final String prefix = "reip-";

    @Autowired
    private ObsClient obsClient;

    @Async
    @Override
    public String getImage(MultipartFile file) {
        String url = null;
        try {
            String originName = file.getOriginalFilename();
            String fix = originName.substring(originName.lastIndexOf('.'));
            PutObjectRequest request = new PutObjectRequest();
            request.setInput(file.getInputStream());
            request.setBucketName(bucket);
            request.setObjectKey(prefix+UUID.randomUUID().toString()+fix);
            request.setExpires(expire);
            request.setAcl(AccessControlList.REST_CANNED_PUBLIC_READ);
            url = obsClient.putObject(request).getObjectUrl();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return url;
    }

}
