package org.example.reip.constant;

/**
 * @author cyan
 * @since 2022/4/11
 */
public enum RecipeStatus {

    DRAFT(0, "草稿"),
    AUDIT(1, "审核"),
    RELEASE(2, "发布");

    int code;
    String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    RecipeStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
