package org.example.mall.model.po;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_cargo_header")
@AllArgsConstructor
@NoArgsConstructor
public class CargoPo {
    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 货仓id
     */
    @Column(name = "warehouse_id")
    private Long warehouseId;

    /**
     * 货物名称 空格分割名字与一包大小
     */
    @Column(name = "cargo_name")
    private String cargoName;

    /**
     * 价格
     */
    @Column(name = "cargo_price")
    private BigDecimal cargoPrice;

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
     * 封面
     */
    @Column(name = "cargo_img")
    private String cargoImg;

    /**
     * 发货信息
     */
    @Column(name = "cargo_ship_info")
    private String cargoShipInfo;

    /**
     * 图文详情
     */
    @Column(name = "cargo_text")
    private String cargoText;

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
     * 获取货物名称 空格分割名字与一包大小
     *
     * @return cargo_name - 货物名称 空格分割名字与一包大小
     */
    public String getCargoName() {
        return cargoName;
    }

    /**
     * 设置货物名称 空格分割名字与一包大小
     *
     * @param cargoName 货物名称 空格分割名字与一包大小
     */
    public void setCargoName(String cargoName) {
        this.cargoName = cargoName == null ? null : cargoName.trim();
    }

    /**
     * 获取价格
     *
     * @return cargo_price - 价格
     */
    public BigDecimal getCargoPrice() {
        return cargoPrice;
    }

    /**
     * 设置价格
     *
     * @param cargoPrice 价格
     */
    public void setCargoPrice(BigDecimal cargoPrice) {
        this.cargoPrice = cargoPrice;
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
     * 获取封面
     *
     * @return cargo_img - 封面
     */
    public String getCargoImg() {
        return cargoImg;
    }

    /**
     * 设置封面
     *
     * @param cargoImg 封面
     */
    public void setCargoImg(String cargoImg) {
        this.cargoImg = cargoImg == null ? null : cargoImg.trim();
    }

    /**
     * 获取发货信息
     *
     * @return cargo_ship_info - 发货信息
     */
    public String getCargoShipInfo() {
        return cargoShipInfo;
    }

    /**
     * 设置发货信息
     *
     * @param cargoShipInfo 发货信息
     */
    public void setCargoShipInfo(String cargoShipInfo) {
        this.cargoShipInfo = cargoShipInfo == null ? null : cargoShipInfo.trim();
    }

    /**
     * 获取图文详情
     *
     * @return cargo_text - 图文详情
     */
    public String getCargoText() {
        return cargoText;
    }

    /**
     * 设置图文详情
     *
     * @param cargoText 图文详情
     */
    public void setCargoText(String cargoText) {
        this.cargoText = cargoText == null ? null : cargoText.trim();
    }
}