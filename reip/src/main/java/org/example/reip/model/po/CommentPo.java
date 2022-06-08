package org.example.reip.model.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "rec_comment")
public class CommentPo {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * user
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 0 菜谱，1作品
     */
    @Column(name = "comment_type")
    private Byte commentType;

    @Column(name = "comment_root_id")
    private Integer commentRootId;

    /**
     * 菜谱id或者作品id
     */
    @Column(name = "comment_type_id")
    private Integer commentTypeId;

    /**
     * 点赞
     */
    @Column(name = "comment_thumb")
    private Integer commentThumb;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 评语
     */
    @Column(name = "comment_text")
    private String commentText;

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
     * 获取user
     *
     * @return user_id - user
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置user
     *
     * @param userId user
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取0 菜谱，1作品
     *
     * @return comment_type - 0 菜谱，1作品
     */
    public Byte getCommentType() {
        return commentType;
    }

    /**
     * 设置0 菜谱，1作品
     *
     * @param commentType 0 菜谱，1作品
     */
    public void setCommentType(Byte commentType) {
        this.commentType = commentType;
    }

    /**
     * @return comment_root_id
     */
    public Integer getCommentRootId() {
        return commentRootId;
    }

    /**
     * @param commentRootId
     */
    public void setCommentRootId(Integer commentRootId) {
        this.commentRootId = commentRootId;
    }

    /**
     * 获取菜谱id或者作品id
     *
     * @return comment_type_id - 菜谱id或者作品id
     */
    public Integer getCommentTypeId() {
        return commentTypeId;
    }

    /**
     * 设置菜谱id或者作品id
     *
     * @param commentTypeId 菜谱id或者作品id
     */
    public void setCommentTypeId(Integer commentTypeId) {
        this.commentTypeId = commentTypeId;
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
}