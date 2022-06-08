package org.example.usve.model.po;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Builder
@Table(name = "usve_user")
public class UserPo {

    /**
     * 手机号
     */
    @Id
    @Column(name = "user_phone")
    private String userPhone;

    /**
     * 生日
     */
    @Column(name = "user_birth")
    private String userBirth;

    /**
     * 性别
     */
    @Column(name = "user_sex")
    private String userSex;

    /**
     * 昵称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 头像
     */
    @Column(name = "user_avatar")
    private String userAvatar;

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
     * 职业
     */
    @Column(name = "user_occp")
    private String userOccp;

    /**
     * 家乡
     */
    @Column(name = "user_home")
    private String userHome;

    /**
     * 常居地
     */
    @Column(name = "user_permanent_residence")
    private String userPermanentResidence;

    /**
     * 订单号
     */
    @Column(name = "user_order")
    private Integer userOrder;

    /**
     * 描述
     */
    @Column(name = "user_text")
    private String userText;

    /**
     * 关注数
     */
    @Transient
    private Integer userFollow;

    /**
     * 粉丝数
     */
    @Transient
    private Integer userFans;

    public UserPo() {
    }

    public UserPo(String userPhone, String userBirth, String userSex, String userName, String userAvatar
            , Date createTime, Date updateTime, String userOccp, String userHome
            , String userPermanentResidence, Integer userOrder, String userText) {
        this.userPhone = userPhone;
        this.userBirth = userBirth;
        this.userSex = userSex;
        this.userName = userName;
        this.userAvatar = userAvatar;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.userOccp = userOccp;
        this.userHome = userHome;
        this.userPermanentResidence = userPermanentResidence;
        this.userOrder = userOrder;
        this.userText = userText;
    }

    public UserPo(String userPhone, String userBirth, String userSex, String userName
            , String userAvatar, Date createTime, Date updateTime, String userOccp
            , String userHome, String userPermanentResidence, Integer userOrder
            , String userText, Integer userFollow, Integer userFans) {
        this.userPhone = userPhone;
        this.userBirth = userBirth;
        this.userSex = userSex;
        this.userName = userName;
        this.userAvatar = userAvatar;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.userOccp = userOccp;
        this.userHome = userHome;
        this.userPermanentResidence = userPermanentResidence;
        this.userOrder = userOrder;
        this.userText = userText;
        this.userFollow = userFollow;
        this.userFans = userFans;
    }

    /**
     * 获取关注数
     *
     * @return follow
     */
    public Integer getUserFollow() {
        return userFollow;
    }

    /**
     * 设置关注数
     *
     * @param userFollow 关注
     */
    public void setUserFollow(Integer userFollow) {
        this.userFollow = userFollow;
    }

    /**
     * 获取粉丝数
     *
     * @return 粉丝
     */
    public Integer getUserFans() {
        return userFans;
    }

    /**
     * 设置粉丝数
     *
     * @param userFans
     */
    public void setUserFans(Integer userFans) {
        this.userFans = userFans;
    }

    /**
     * 获取手机号
     *
     * @return user_phone - 手机号
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 设置手机号
     *
     * @param userPhone 手机号
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /**
     * 获取生日
     *
     * @return user_birth - 生日
     */
    public String getUserBirth() {
        return userBirth;
    }

    /**
     * 设置生日
     *
     * @param userBirth 生日
     */
    public void setUserBirth(String userBirth) {
        this.userBirth = userBirth == null ? null : userBirth.trim();
    }

    /**
     * 获取性别
     *
     * @return user_sex - 性别
     */
    public String getUserSex() {
        return userSex;
    }

    /**
     * 设置性别
     *
     * @param userSex 性别
     */
    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    /**
     * 获取昵称
     *
     * @return user_name - 昵称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置昵称
     *
     * @param userName 昵称
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取头像
     *
     * @return user_avatar - 头像
     */
    public String getUserAvatar() {
        return userAvatar;
    }

    /**
     * 设置头像
     *
     * @param userAvatar 头像
     */
    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar == null ? null : userAvatar.trim();
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
     * 获取职业
     *
     * @return user_occp - 职业
     */
    public String getUserOccp() {
        return userOccp;
    }

    /**
     * 设置职业
     *
     * @param userOccp 职业
     */
    public void setUserOccp(String userOccp) {
        this.userOccp = userOccp == null ? null : userOccp.trim();
    }

    /**
     * 获取家乡
     *
     * @return user_home - 家乡
     */
    public String getUserHome() {
        return userHome;
    }

    /**
     * 设置家乡
     *
     * @param userHome 家乡
     */
    public void setUserHome(String userHome) {
        this.userHome = userHome == null ? null : userHome.trim();
    }

    /**
     * 获取常居地
     *
     * @return user_permanent_residence - 常居地
     */
    public String getUserPermanentResidence() {
        return userPermanentResidence;
    }

    /**
     * 设置常居地
     *
     * @param userPermanentResidence 常居地
     */
    public void setUserPermanentResidence(String userPermanentResidence) {
        this.userPermanentResidence = userPermanentResidence == null ? null : userPermanentResidence.trim();
    }

    /**
     * 获取订单号
     *
     * @return user_order - 订单号
     */
    public Integer getUserOrder() {
        return userOrder;
    }

    /**
     * 设置订单号
     *
     * @param userOrder 订单号
     */
    public void setUserOrder(Integer userOrder) {
        this.userOrder = userOrder;
    }

    /**
     * 获取描述
     *
     * @return user_text - 描述
     */
    public String getUserText() {
        return userText;
    }

    /**
     * 设置描述
     *
     * @param userText 描述
     */
    public void setUserText(String userText) {
        this.userText = userText == null ? null : userText.trim();
    }

    @Override
    public String toString() {
        return "UserPo{" +
                "userPhone='" + userPhone + '\'' +
                ", userBirth='" + userBirth + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userName='" + userName + '\'' +
                ", userAvatar='" + userAvatar + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", userOccp='" + userOccp + '\'' +
                ", userHome='" + userHome + '\'' +
                ", userPermanentResidence='" + userPermanentResidence + '\'' +
                ", userOrder=" + userOrder +
                ", userText='" + userText + '\'' +
                ", userFollow=" + userFollow +
                ", userFans=" + userFans +
                '}';
    }
    
}