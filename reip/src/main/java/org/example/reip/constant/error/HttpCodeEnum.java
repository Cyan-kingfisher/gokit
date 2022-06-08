package org.example.reip.constant.error;

/**
 * @author cyan
 * @since 2022/4/11
 */
public enum HttpCodeEnum {

    TokenExpired("20100", "TokenExpired", "登录失败，token失效"),
    JWTDecode("20101", "JWTDecode", "登录失败，token解析错误"),
    HttpRequestMethodNotSupported("20102", "HttpRequestMethodNotSupported", "请求方法错误"),
    BadSqlGrammar("20103", "BadSqlGrammar", "系统错误"),
    RedisConnectionFailure("20104", "RedisConnectionFailure", "数据库Redis连接失败"),
    MissingRequestHeader("20107", "MissingRequestHeader", "请登录后操作"),
    MyBatisSystem("20108", "MyBatisSystem", "数据库连接失败"),
    Bind("20141", "Bind", "参数不符要求"),
    FeignServer("20111", "FeignServer", "调用其他服务异常"),
    HttpMessageNotReadable("20208", "HttpMessageNotReadable", "请求格式不符要求"),
    DEFAULT("20209", "Gradu", "未知错误，待定位"),

    PREFIX_TOKEN("20701", "prefix token", "token需要前缀"),
    ARGS_ARRAY_ALIGNMENT("20720", "Argument array alignment", "入参对象内置数组不对齐"),
    PHONE_VALIDATOR("20702", "PHONE_VALIDATOR", "手机号格式错误"),
    // 20703|UserInfo is null
    NO_LOGIN("20706", "No login permission", "请登录后操作"),
    FILE_NULL("20714", "file is null", "获取文件为空"),
    PARAM_NULL("20718", "parameter is null", "参数为空"),
    //    USER_INFO_NULL("20721", "user data is null", "用户数据为空")
    SEARCH_RECIPE("20717", "screen recipe exception", "菜谱筛选异常"),
    PAGEHELPER_ERROR("20710", "pagehelper error", "分页参数PageSize>=0"),
    RECIPE_UP_STEP_COUNT("20712", "recipe step limit 1 and 20", "菜谱步骤数至少为1, 至多20");

    private String code;
    private String key;
    private String message;

    HttpCodeEnum(String code, String key, String message) {
        this.code = code;
        this.key = key;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static HttpCodeEnum getError(String key) {
        key = key.substring(0, key.indexOf("Exception"));
        HttpCodeEnum[] errors = values();
        for (HttpCodeEnum value : errors) {
            if (key.equals(value.getKey())) {
                return value;
            }
        }
        return DEFAULT;
    }

    @Override
    public String toString() {
        return code + "|" + message;
    }
}
