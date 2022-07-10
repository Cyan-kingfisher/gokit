package org.example.usve.model.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "usve_special_user")
public class SpecialUserPo {
    /**
     * id
     */
    @Id
    private String id;

    /**
     * 用户名
     */
    @Column(name = "special_user_name")
    private String specialUserName;

    /**
     * 密码
     */
    @Column(name = "special_password")
    private String specialPassword;

    /**
     * 类别
     */
    @Column(name = "special_identity")
    private String specialIdentity;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取id
     *
     * @return id - id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取用户名
     *
     * @return special_user_name - 用户名
     */
    public String getSpecialUserName() {
        return specialUserName;
    }

    /**
     * 设置用户名
     *
     * @param specialUserName 用户名
     */
    public void setSpecialUserName(String specialUserName) {
        this.specialUserName = specialUserName == null ? null : specialUserName.trim();
    }

    /**
     * 获取密码
     *
     * @return special_password - 密码
     */
    public String getSpecialPassword() {
        return specialPassword;
    }

    /**
     * 设置密码
     *
     * @param specialPassword 密码
     */
    public void setSpecialPassword(String specialPassword) {
        this.specialPassword = specialPassword == null ? null : specialPassword.trim();
    }

    /**
     * 获取类别
     *
     * @return special_identity - 类别
     */
    public String getSpecialIdentity() {
        return specialIdentity;
    }

    /**
     * 设置类别
     *
     * @param specialIdentity 类别
     */
    public void setSpecialIdentity(String specialIdentity) {
        this.specialIdentity = specialIdentity == null ? null : specialIdentity.trim();
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}