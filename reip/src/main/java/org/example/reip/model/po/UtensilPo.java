package org.example.reip.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;

@AllArgsConstructor
@Builder
@Table(name = "base_utensil")
public class UtensilPo {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 品牌
     */
    @Column(name = "utensil_brand")
    private String utensilBrand;

    /**
     * 型号
     */
    @Column(name = "utensil_model")
    private String utensilModel;

    /**
     * 用具
     */
    @Column(name = "utensil_type")
    private String utensilType;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取品牌
     *
     * @return utensil_brand - 品牌
     */
    public String getUtensilBrand() {
        return utensilBrand;
    }

    /**
     * 设置品牌
     *
     * @param utensilBrand 品牌
     */
    public void setUtensilBrand(String utensilBrand) {
        this.utensilBrand = utensilBrand == null ? null : utensilBrand.trim();
    }

    /**
     * 获取型号
     *
     * @return utensil_model - 型号
     */
    public String getUtensilModel() {
        return utensilModel;
    }

    /**
     * 设置型号
     *
     * @param utensilModel 型号
     */
    public void setUtensilModel(String utensilModel) {
        this.utensilModel = utensilModel == null ? null : utensilModel.trim();
    }

    /**
     * 获取用具
     *
     * @return utensil_type - 用具
     */
    public String getUtensilType() {
        return utensilType;
    }

    /**
     * 设置用具
     *
     * @param utensilType 用具
     */
    public void setUtensilType(String utensilType) {
        this.utensilType = utensilType == null ? null : utensilType.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}