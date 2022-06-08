package org.example.reip.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "rec_head")
public class RecipeHeaderPo {
    /**
     * 菜谱id
     */
    @Id
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 菜谱名称
     */
    @Column(name = "recipe_name")
    private String recipeName;

    /**
     * 烹饪时长
     */
    @Column(name = "recipe_time")
    private String recipeTime;

    /**
     * 烹饪难度
     */
    @Column(name = "recipe_difficulty")
    private String recipeDifficulty;

    /**
     * 分类，标签, 不能包含“,”
     */
    @Column(name = "recipe_lable")
    private String recipeLable;

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
     * 状态 012 草稿，待审核，发布
     */
    private Integer status;

    /**
     * 菜谱图片
     */
    @Column(name = "recipe_image")
    private String recipeImage;

    /**
     * 菜谱描述
     */
    @Column(name = "recipe_describe")
    private String recipeDescribe;

    /**
     * 小贴士
     */
    @Column(name = "recipe_tips")
    private String recipeTips;

    /**
     * 获取菜谱id
     *
     * @return id - 菜谱id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置菜谱id
     *
     * @param id 菜谱id
     */
    public void setId(Integer id) {
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
     * 获取菜谱名称
     *
     * @return recipe_name - 菜谱名称
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * 设置菜谱名称
     *
     * @param recipeName 菜谱名称
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName == null ? null : recipeName.trim();
    }

    /**
     * 获取烹饪时长
     *
     * @return recipe_time - 烹饪时长
     */
    public String getRecipeTime() {
        return recipeTime;
    }

    /**
     * 设置烹饪时长
     *
     * @param recipeTime 烹饪时长
     */
    public void setRecipeTime(String recipeTime) {
        this.recipeTime = recipeTime == null ? null : recipeTime.trim();
    }

    /**
     * 获取烹饪难度
     *
     * @return recipe_difficulty - 烹饪难度
     */
    public String getRecipeDifficulty() {
        return recipeDifficulty;
    }

    /**
     * 设置烹饪难度
     *
     * @param recipeDifficulty 烹饪难度
     */
    public void setRecipeDifficulty(String recipeDifficulty) {
        this.recipeDifficulty = recipeDifficulty == null ? null : recipeDifficulty.trim();
    }

    /**
     * 获取分类，标签，，，不能包含“,”
     *
     * @return recipe_lable - 分类，标签，，，不能包含“,”
     */
    public String getRecipeLable() {
        return recipeLable;
    }

    /**
     * 设置分类，标签，，，不能包含“,”
     *
     * @param recipeLable 分类，标签，，，不能包含“,”
     */
    public void setRecipeLable(String recipeLable) {
        this.recipeLable = recipeLable == null ? null : recipeLable.trim();
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
     * 获取状态 012 草稿，待审核，发布
     *
     * @return status - 状态 012 草稿，待审核，发布
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 012 草稿，待审核，发布
     *
     * @param status 状态 012 草稿，待审核，发布
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取菜谱图片
     *
     * @return recipe_image - 菜谱图片
     */
    public String getRecipeImage() {
        return recipeImage;
    }

    /**
     * 设置菜谱图片
     *
     * @param recipeImage 菜谱图片
     */
    public void setRecipeImage(String recipeImage) {
        this.recipeImage = recipeImage == null ? null : recipeImage.trim();
    }

    /**
     * 获取菜谱描述
     *
     * @return recipe_describe - 菜谱描述
     */
    public String getRecipeDescribe() {
        return recipeDescribe;
    }

    /**
     * 设置菜谱描述
     *
     * @param recipeDescribe 菜谱描述
     */
    public void setRecipeDescribe(String recipeDescribe) {
        this.recipeDescribe = recipeDescribe == null ? null : recipeDescribe.trim();
    }

    /**
     * 获取小贴士
     *
     * @return recipe_tips - 小贴士
     */
    public String getRecipeTips() {
        return recipeTips;
    }

    /**
     * 设置小贴士
     *
     * @param recipeTips 小贴士
     */
    public void setRecipeTips(String recipeTips) {
        this.recipeTips = recipeTips == null ? null : recipeTips.trim();
    }
}