package org.example.reip.util;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author cyan
 * @since 2022/6/2
 */
public class GoKitUtil {

    public static boolean isNotNullForList(List... obj) {
        boolean result = true;
        for (List args : obj) {
            result = result && StringUtils.isEmpty(args);
        }
        return result;
    }

    public static boolean isNotNulForFile(MultipartFile file) {
        return file != null && !file.isEmpty();
    }

}
