package org.example.reip.model.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "rec_collect")
public class CollectPo {
    /**
     * 收藏id
     */
    @Id
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 菜谱id
     */
    @Column(name = "recipe_id")
    private Integer recipeId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取收藏id
     *
     * @return id - 收藏id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置收藏id
     *
     * @param id 收藏id
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