package org.example.reip.model.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "rec_works")
public class RecipeWorkPo {
    @Id
    private Integer id;

    /**
     * 用户
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 菜谱id
     */
    @Column(name = "recipe_id")
    private Integer recipeId;

    /**
     * 点赞
     */
    @Column(name = "works_thumb")
    private Integer worksThumb;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 描述
     */
    @Column(name = "works_text")
    private String worksText;

    /**
     * 图片3
     */
    @Column(name = "works_im3")
    private String worksIm3;

    /**
     * 图片1
     */
    @Column(name = "works_img1")
    private String worksImg1;

    /**
     * 图片2
     */
    @Column(name = "works_img2")
    private String worksImg2;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户
     *
     * @return user_id - 用户
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户
     *
     * @param userId 用户
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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
     * 获取点赞
     *
     * @return works_thumb - 点赞
     */
    public Integer getWorksThumb() {
        return worksThumb;
    }

    /**
     * 设置点赞
     *
     * @param worksThumb 点赞
     */
    public void setWorksThumb(Integer worksThumb) {
        this.worksThumb = worksThumb;
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

    /**
     * 获取描述
     *
     * @return works_text - 描述
     */
    public String getWorksText() {
        return worksText;
    }

    /**
     * 设置描述
     *
     * @param worksText 描述
     */
    public void setWorksText(String worksText) {
        this.worksText = worksText == null ? null : worksText.trim();
    }

    /**
     * 获取图片3
     *
     * @return works_im3 - 图片3
     */
    public String getWorksIm3() {
        return worksIm3;
    }

    /**
     * 设置图片3
     *
     * @param worksIm3 图片3
     */
    public void setWorksIm3(String worksIm3) {
        this.worksIm3 = worksIm3 == null ? null : worksIm3.trim();
    }

    /**
     * 获取图片1
     *
     * @return works_img1 - 图片1
     */
    public String getWorksImg1() {
        return worksImg1;
    }

    /**
     * 设置图片1
     *
     * @param worksImg1 图片1
     */
    public void setWorksImg1(String worksImg1) {
        this.worksImg1 = worksImg1 == null ? null : worksImg1.trim();
    }

    /**
     * 获取图片2
     *
     * @return works_img2 - 图片2
     */
    public String getWorksImg2() {
        return worksImg2;
    }

    /**
     * 设置图片2
     *
     * @param worksImg2 图片2
     */
    public void setWorksImg2(String worksImg2) {
        this.worksImg2 = worksImg2 == null ? null : worksImg2.trim();
    }
}