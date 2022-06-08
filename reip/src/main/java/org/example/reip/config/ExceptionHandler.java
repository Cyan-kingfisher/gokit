package org.example.reip.config;

import lombok.extern.slf4j.Slf4j;
import org.example.reip.constant.error.HttpCodeEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author cyan
 * @since 2022/3/26
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler({Exception.class})
    public String exceptionHandler(Exception e, HttpServletRequest request) throws Exception {

        Map<String, Object> map = new LinkedHashMap<>();

        String exceptionName = e.getClass().getSimpleName();
        String exceptionMsg = e.getMessage();
        log.info("ExName:{}, ExMsg:{}", exceptionName, exceptionMsg);
        e.printStackTrace();

        HttpCodeEnum error = HttpCodeEnum.getError(exceptionName);

        map.put("code", error.getCode());
        map.put("msg", error.getMessage());

        if (exceptionMsg.contains("|")) {
            String[] data = exceptionMsg.split("\\|");
            map.put("code", data[0]);
            map.put("msg", data[1]);
        }

        map.put("descriptions", exceptionName+" "+e.getMessage());
        request.setAttribute("javax.servlet.error.status_code", 505);
        request.setAttribute("exMap", map);

        return "forward:/error";
    }
}
