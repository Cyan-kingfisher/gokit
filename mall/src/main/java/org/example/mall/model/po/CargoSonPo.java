package org.example.mall.model.po;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_cargo_line")
@AllArgsConstructor
@NoArgsConstructor
public class CargoSonPo {
    /**
     * 商品子类id
     */
    @Id
    @Column(name = "cargo_son_id")
    private Integer cargoSonId;

    /**
     * 商品id
     */
    @Id
    @Column(name = "cargo_id")
    private Long cargoId;

    /**
     * 名称+剂量，空格分割
     */
    @Column(name = "cargo_son_name")
    private String cargoSonName;

    /**
     * 价格
     */
    @Column(name = "cargo_son_price")
    private BigDecimal cargoSonPrice;

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
     * 获取名称+剂量，空格分割
     *
     * @return cargo_son_name - 名称+剂量，空格分割
     */
    public String getCargoSonName() {
        return cargoSonName;
    }

    /**
     * 设置名称+剂量，空格分割
     *
     * @param cargoSonName 名称+剂量，空格分割
     */
    public void setCargoSonName(String cargoSonName) {
        this.cargoSonName = cargoSonName == null ? null : cargoSonName.trim();
    }

    /**
     * 获取价格
     *
     * @return cargo_son_price - 价格
     */
    public BigDecimal getCargoSonPrice() {
        return cargoSonPrice;
    }

    /**
     * 设置价格
     *
     * @param cargoSonPrice 价格
     */
    public void setCargoSonPrice(BigDecimal cargoSonPrice) {
        this.cargoSonPrice = cargoSonPrice;
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