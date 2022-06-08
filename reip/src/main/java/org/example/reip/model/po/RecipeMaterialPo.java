package org.example.reip.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;

@AllArgsConstructor
@Builder
@Table(name = "rce_material")
public class RecipeMaterialPo {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 菜谱id
     */
    @Column(name = "recipe_id")
    private Integer recipeId;

    /**
     * 剂量
     */
    @Column(name = "material_dosage")
    private String materialDosage;

    /**
     * 原料名称
     */
    @Column(name = "material_ingredients")
    private String materialIngredients;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取原料id
     *
     * @return id - 原料id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置原料id
     *
     * @param id 原料id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取菜谱id
     *
     * @return recipe_id - 菜谱id
     */
    public Integer getRecipeId() {
        return recipeId;
    }

    /**
     * 设置菜谱id
     *
     * @param recipeId 菜谱id
     */
    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    /**
     * 获取剂量
     *
     * @return material_dosage - 剂量
     */
    public String getMaterialDosage() {
        return materialDosage;
    }

    /**
     * 设置剂量
     *
     * @param materialDosage 剂量
     */
    public void setMaterialDosage(String materialDosage) {
        this.materialDosage = materialDosage == null ? null : materialDosage.trim();
    }

    /**
     * 获取原料名称
     *
     * @return material_ingredients - 原料名称
     */
    public String getMaterialIngredients() {
        return materialIngredients;
    }

    /**
     * 设置原料名称
     *
     * @param materialIngredients 原料名称
     */
    public void setMaterialIngredients(String materialIngredients) {
        this.materialIngredients = materialIngredients == null ? null : materialIngredients.trim();
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