package org.example.reip.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Date;
import javax.persistence.*;

@AllArgsConstructor
@Builder
@Table(name = "rec_practice")
public class RecipeStepPo {
    /**
     * 步骤id
     */
    @Id
    private Integer id;

    /**
     * 菜谱id
     */
    @Column(name = "recipe_id")
    private Integer recipeId;

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
     * 步骤图
     */
    @Column(name = "practice_media")
    private String practiceMedia;

    /**
     * 步骤描述
     */
    @Column(name = "practice_text")
    private String practiceText;

    /**
     * 获取步骤id
     *
     * @return id - 步骤id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置步骤id
     *
     * @param id 步骤id
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
     * 获取步骤图
     *
     * @return practice_media - 步骤图
     */
    public String getPracticeMedia() {
        return practiceMedia;
    }

    /**
     * 设置步骤图
     *
     * @param practiceMedia 步骤图
     */
    public void setPracticeMedia(String practiceMedia) {
        this.practiceMedia = practiceMedia == null ? null : practiceMedia.trim();
    }

    /**
     * 获取步骤描述
     *
     * @return practice_text - 步骤描述
     */
    public String getPracticeText() {
        return practiceText;
    }

    /**
     * 设置步骤描述
     *
     * @param practiceText 步骤描述
     */
    public void setPracticeText(String practiceText) {
        this.practiceText = practiceText == null ? null : practiceText.trim();
    }
}