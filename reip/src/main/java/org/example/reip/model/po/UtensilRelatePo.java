package org.example.reip.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Date;
import javax.persistence.*;

@AllArgsConstructor
@Builder
@Table(name = "rce_utensil_relation")
public class UtensilRelatePo {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 菜谱id
     */
    @Column(name = "recipe_id")
    private Integer recipeId;

    /**
     * 厨具id
     */
    @Column(name = "utensil_id")
    private Integer utensilId;

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
     * 获取厨具id
     *
     * @return utensil_id - 厨具id
     */
    public Integer getUtensilId() {
        return utensilId;
    }

    /**
     * 设置厨具id
     *
     * @param utensilId 厨具id
     */
    public void setUtensilId(Integer utensilId) {
        this.utensilId = utensilId;
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