package org.example.usve.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "usve_follow")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FollowPo {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * A, A关注B
     */
    @Column(name = "follow_forward")
    private String followForward;

    /**
     * B, A关注B
     */
    @Column(name = "follow_back")
    private String followBack;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取A, A关注B
     *
     * @return follow_forward - A, A关注B
     */
    public String getFollowForward() {
        return followForward;
    }

    /**
     * 设置A, A关注B
     *
     * @param followForward A, A关注B
     */
    public void setFollowForward(String followForward) {
        this.followForward = followForward == null ? null : followForward.trim();
    }

    /**
     * 获取B, A关注B
     *
     * @return follow_back - B, A关注B
     */
    public String getFollowBack() {
        return followBack;
    }

    /**
     * 设置B, A关注B
     *
     * @param followBack B, A关注B
     */
    public void setFollowBack(String followBack) {
        this.followBack = followBack == null ? null : followBack.trim();
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
}