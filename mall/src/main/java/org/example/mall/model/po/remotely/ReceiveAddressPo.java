package org.example.mall.model.po.remotely;

import java.util.Date;
import javax.persistence.*;

@Table(name = "usve_receive_address")
public class ReceiveAddressPo {
    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 手机号
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 姓名
     */
    @Column(name = "address_name")
    private String addressName;

    /**
     * 11位手机号
     */
    @Column(name = "address_phone")
    private String addressPhone;

    /**
     * 省市区街道 ,分割
     */
    @Column(name = "address_super")
    private String addressSuper;

    /**
     * 详细地址
     */
    @Column(name = "address_detail")
    private String addressDetail;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 默认地址，1表示默认地址
     */
    @Column(name = "address_default")
    private Integer addressDefault;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取手机号
     *
     * @return user_id - 手机号
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置手机号
     *
     * @param userId 手机号
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取姓名
     *
     * @return address_name - 姓名
     */
    public String getAddressName() {
        return addressName;
    }

    /**
     * 设置姓名
     *
     * @param addressName 姓名
     */
    public void setAddressName(String addressName) {
        this.addressName = addressName == null ? null : addressName.trim();
    }

    /**
     * 获取11位手机号
     *
     * @return address_phone - 11位手机号
     */
    public String getAddressPhone() {
        return addressPhone;
    }

    /**
     * 设置11位手机号
     *
     * @param addressPhone 11位手机号
     */
    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone == null ? null : addressPhone.trim();
    }

    /**
     * 获取省市区街道 ,分割
     *
     * @return address_super - 省市区街道 ,分割
     */
    public String getAddressSuper() {
        return addressSuper;
    }

    /**
     * 设置省市区街道 ,分割
     *
     * @param addressSuper 省市区街道 ,分割
     */
    public void setAddressSuper(String addressSuper) {
        this.addressSuper = addressSuper == null ? null : addressSuper.trim();
    }

    /**
     * 获取详细地址
     *
     * @return address_detail - 详细地址
     */
    public String getAddressDetail() {
        return addressDetail;
    }

    /**
     * 设置详细地址
     *
     * @param addressDetail 详细地址
     */
    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail == null ? null : addressDetail.trim();
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
     * 获取默认地址，1表示默认地址
     *
     * @return address_default - 默认地址，1表示默认地址
     */
    public Integer getAddressDefault() {
        return addressDefault;
    }

    /**
     * 设置默认地址，1表示默认地址
     *
     * @param addressDefault 默认地址，1表示默认地址
     */
    public void setAddressDefault(Integer addressDefault) {
        this.addressDefault = addressDefault;
    }
}