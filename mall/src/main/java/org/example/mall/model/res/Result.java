package org.example.mall.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回信息格式
 *
 * @author cyan
 * @since 2022/3/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result<T> {

    /**
     * msg | success
     */
    private String msg;

    /**
     * code | 00000
     */
    private String code;

    /**
     * data
     */
    private T data;

    public static Result success() {
        return Result.builder().code("00000").msg("success").build();
    }

    public static Result failLogin() {
        return Result.builder().code("104").msg("login fail").build();
    }

    public static Result fail(String mesg) {
        return Result.builder().code("302").msg(mesg).build();
    }

    public static Result success(Object obj) {
        return Result.builder().code("00000").msg("success").data(obj).build();
    }

    public static Result success(String key, Object data) {
        Map<String, Object> map = new HashMap<>(1);
        map.put(key, data);
        return Result.builder().code("00000").msg("success").data(map).build();
    }

}
