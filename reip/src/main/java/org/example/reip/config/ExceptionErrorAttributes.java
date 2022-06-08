package org.example.reip.config;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
import java.util.Set;

/**
 * @author cyan
 * @since 2022/3/26
 */
@Component
public class ExceptionErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, options);
        Map<String, Object> exMap = (Map<String, Object>) webRequest.getAttribute("exMap", 0);
        Set<String> set = exMap.keySet();
        for (String str:set) {
            map.put(str, exMap.get(str));
        }
        return map;
    }
}
