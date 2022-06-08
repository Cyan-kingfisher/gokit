package org.example.mall.model.po;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_shop_line")
@AllArgsConstructor
@NoArgsConstructor
public class ShopLinePo {
    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 货仓id
     */
    @Column(name = "warehouse_id")
    private Long warehouseId;

    /**
     * 商品id
     */
    @Column(name = "cargo_id")
    private Long cargoId;

    /**
     * 商品子类id
     */
    @Column(name = "cargo_son_id")
    private Integer cargoSonId;

    /**
     * 该商品总价
     */
    @Column(name = "cargo_price")
    private BigDecimal cargoPrice;

    /**
     * 该商品数量
     */
    @Column(name = "cargo_count")
    private Integer cargoCount;

    /**
     * 状态，0表示正常，1表示不在购物车显示，被订单纳入
     */
    @Column(name = "shop_status")
    private Integer shopStatus;

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
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取货仓id
     *
     * @return warehouse_id - 货仓id
     */
    public Long getWarehouseId() {
        return warehouseId;
    }

    /**
     * 设置货仓id
     *
     * @param warehouseId 货仓id
     */
    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    /**
     * 获取商品id
     *
     * @return cargo_id - 商品id
     */
    public Long getCargoId() {
        return cargoId;
    }

    /**
     * 设置商品id
     *
     * @param cargoId 商品id
     */
    public void setCargoId(Long cargoId) {
        this.cargoId = cargoId;
    }

    /**
     * 获取商品子类id
     *
     * @return cargo_son_id - 商品子类id
     */
    public Integer getCargoSonId() {
        return cargoSonId;
    }

    /**
     * 设置商品子类id
     *
     * @param cargoSonId 商品子类id
     */
    public void setCargoSonId(Integer cargoSonId) {
        this.cargoSonId = cargoSonId;
    }

    /**
     * 获取该商品总价
     *
     * @return cargo_price - 该商品总价
     */
    public BigDecimal getCargoPrice() {
        return cargoPrice;
    }

    /**
     * 设置该商品总价
     *
     * @param cargoPrice 该商品总价
     */
    public void setCargoPrice(BigDecimal cargoPrice) {
        this.cargoPrice = cargoPrice;
    }

    /**
     * 获取该商品数量
     *
     * @return cargo_count - 该商品数量
     */
    public Integer getCargoCount() {
        return cargoCount;
    }

    /**
     * 设置该商品数量
     *
     * @param cargoCount 该商品数量
     */
    public void setCargoCount(Integer cargoCount) {
        this.cargoCount = cargoCount;
    }

    /**
     * 获取状态，0表示正常，1表示不在购物车显示，被订单纳入
     *
     * @return shop_status - 状态，0表示正常，1表示不在购物车显示，被订单纳入
     */
    public Integer getShopStatus() {
        return shopStatus;
    }

    /**
     * 设置状态，0表示正常，1表示不在购物车显示，被订单纳入
     *
     * @param shopStatus 状态，0表示正常，1表示不在购物车显示，被订单纳入
     */
    public void setShopStatus(Integer shopStatus) {
        this.shopStatus = shopStatus;
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