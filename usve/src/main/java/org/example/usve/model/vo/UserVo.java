package org.example.usve.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.util.StringUtil;

/**
 * @author cyan
 * @since 2022/3/23
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class UserVo {
    /**
     * phone
     */
    private String phone;
    /**
     * avatar
     */
    private String avatar;
    /**
     * username
     */
    private String username;
    /**
     * sex
     */
    private String sex;
    /**
     * birthday
     */
    private String birthday;
    /**
     * person describe
     */
    private String describe;
    /**
     * occp
     */
    private String occp;
    /**
     * home
     */
    private String home;
    /**
     * permanentResidence
     */
    private String permanentResidence;

    public boolean isEmpty() {
        return StringUtil.isEmpty(this.avatar)
                && StringUtil.isEmpty(this.username)
                && StringUtil.isEmpty(this.sex)
                && StringUtil.isEmpty(this.birthday)
                && StringUtil.isEmpty(this.describe)
                && StringUtil.isEmpty(this.occp)
                && StringUtil.isEmpty(this.home)
                && StringUtil.isEmpty(this.permanentResidence);
    }
}
