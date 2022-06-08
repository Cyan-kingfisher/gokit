package org.example.mall.model.po;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_warehouse")
@AllArgsConstructor
@NoArgsConstructor
public class WarehousePo {
    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 货仓名称
     */
    @Column(name = "warehouse_name")
    private String warehouseName;

    /**
     * 邮费
     */
    @Column(name = "warehouse_freight")
    private BigDecimal warehouseFreight;

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
     * 获取货仓名称
     *
     * @return warehouse_name - 货仓名称
     */
    public String getWarehouseName() {
        return warehouseName;
    }

    /**
     * 设置货仓名称
     *
     * @param warehouseName 货仓名称
     */
    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName == null ? null : warehouseName.trim();
    }

    /**
     * 获取邮费
     *
     * @return warehouse_freight - 邮费
     */
    public BigDecimal getWarehouseFreight() {
        return warehouseFreight;
    }

    /**
     * 设置邮费
     *
     * @param warehouseFreight 邮费
     */
    public void setWarehouseFreight(BigDecimal warehouseFreight) {
        this.warehouseFreight = warehouseFreight;
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