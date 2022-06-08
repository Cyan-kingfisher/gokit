package org.example.reip.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * @author cyan
 * @since 2022/4/12
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDto {
    /**
     * id
     */
    @Id
    private Integer id;

    /**
     * 用户头像
     */
    private String userAvatar;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户id
     */
    private String userPhone;

    /**
     * 该评论的父评论id，无父评论时为null
     */
    private Integer commentRootId;

    /**
     * 点赞
     */
    private Integer commentThumb;

    private Date createTime;

    /**
     * 评语
     */
    private String commentText;

    /**
     * 子评论
     */
    private List<CommentSon> commentSons;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    private static class CommentSon {
        /**
         * 评论id
         */
        @Id
        private Integer id;

        /**
         * 用户名
         */
        private String userName;
        /**
         * 用户id
         */
        private String userPhone;

        /**
         * 点赞
         */
        private Integer commentThumb;

        private Date createTime;

        /**
         * 评语
         */
        private String commentText;
    }
}
