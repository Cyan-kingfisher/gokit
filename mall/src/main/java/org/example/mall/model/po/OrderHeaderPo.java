package org.example.mall.model.po;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_order_header")
@AllArgsConstructor
@NoArgsConstructor
public class OrderHeaderPo {
    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 地址id
     */
    @Column(name = "address_id")
    private Long addressId;

    /**
     * 总付款
     */
    @Column(name = "order_actual")
    private BigDecimal orderActual;

    /**
     * 运费
     */
    @Column(name = "order_freight")
    private BigDecimal orderFreight;

    /**
     * 订单状态
     */
    @Column(name = "order_status")
    private Integer orderStatus;

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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取地址id
     *
     * @return address_id - 地址id
     */
    public Long getAddressId() {
        return addressId;
    }

    /**
     * 设置地址id
     *
     * @param addressId 地址id
     */
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    /**
     * 获取总付款
     *
     * @return order_actual - 总付款
     */
    public BigDecimal getOrderActual() {
        return orderActual;
    }

    /**
     * 设置总付款
     *
     * @param orderActual 总付款
     */
    public void setOrderActual(BigDecimal orderActual) {
        this.orderActual = orderActual;
    }

    /**
     * 获取运费
     *
     * @return order_freight - 运费
     */
    public BigDecimal getOrderFreight() {
        return orderFreight;
    }

    /**
     * 设置运费
     *
     * @param orderFreight 运费
     */
    public void setOrderFreight(BigDecimal orderFreight) {
        this.orderFreight = orderFreight;
    }

    /**
     * 获取订单状态
     *
     * @return order_status - 订单状态
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * 设置订单状态
     *
     * @param orderStatus 订单状态
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
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
}