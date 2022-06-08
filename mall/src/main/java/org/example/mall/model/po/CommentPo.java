package org.example.mall.model.po;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;

@Table(name = "mall_comment")
@AllArgsConstructor
@NoArgsConstructor
public class CommentPo {
    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 归属商品id
     */
    @Column(name = "cargo_id")
    private Long cargoId;

    /**
     * 父评论
     */
    @Column(name = "comment_root_id")
    private Long commentRootId;

    /**
     * 点赞
     */
    @Column(name = "comment_thumb")
    private Integer commentThumb;

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
     * 评语
     */
    @Column(name = "comment_text")
    private String commentText;

    /**
     * 图片,分割
     */
    @Column(name = "comment_img")
    private String commentImg;

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
     * 获取归属商品id
     *
     * @return cargo_id - 归属商品id
     */
    public Long getCargoId() {
        return cargoId;
    }

    /**
     * 设置归属商品id
     *
     * @param cargoId 归属商品id
     */
    public void setCargoId(Long cargoId) {
        this.cargoId = cargoId;
    }

    /**
     * 获取父评论
     *
     * @return comment_root_id - 父评论
     */
    public Long getCommentRootId() {
        return commentRootId;
    }

    /**
     * 设置父评论
     *
     * @param commentRootId 父评论
     */
    public void setCommentRootId(Long commentRootId) {
        this.commentRootId = commentRootId;
    }

    /**
     * 获取点赞
     *
     * @return comment_thumb - 点赞
     */
    public Integer getCommentThumb() {
        return commentThumb;
    }

    /**
     * 设置点赞
     *
     * @param commentThumb 点赞
     */
    public void setCommentThumb(Integer commentThumb) {
        this.commentThumb = commentThumb;
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
     * 获取评语
     *
     * @return comment_text - 评语
     */
    public String getCommentText() {
        return commentText;
    }

    /**
     * 设置评语
     *
     * @param commentText 评语
     */
    public void setCommentText(String commentText) {
        this.commentText = commentText == null ? null : commentText.trim();
    }

    /**
     * 获取图片,分割
     *
     * @return comment_img - 图片,分割
     */
    public String getCommentImg() {
        return commentImg;
    }

    /**
     * 设置图片,分割
     *
     * @param commentImg 图片,分割
     */
    public void setCommentImg(String commentImg) {
        this.commentImg = commentImg == null ? null : commentImg.trim();
    }
}