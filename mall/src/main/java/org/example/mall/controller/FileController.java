package org.example.mall.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.mall.util.ObsImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cyan
 * @since 2022/4/27
 */
@Slf4j
@RestController
public class FileController {

    @Autowired
    private ObsImageUtil imageUtil;

    @GetMapping("/img/query")
    public List<String> getUrls(MultipartFile[] imgs) {
        List<String> list = new ArrayList<>(imgs.length);
        for (MultipartFile img : imgs) {
            list.add(imageUtil.getImage(img));
        }
        StringBuilder builder = new StringBuilder();
        for (String str: list) {
            builder.append(str).append(",");
        }
        log.info("urls: "+builder.toString());
        return list;
    }

}
