package org.example.mall.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author cyan
 * @since 2022/4/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    /**
     * id
     */
    private Long id;

    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户头像
     */
    private String userAvatar;
    /**
     * 用户名
     */
    private String userName;

    /**
     * 点赞
     */
    private Integer commentThumb;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 评语
     */
    private String commentText;

    /**
     * 图片,分割
     */
    private String commentImg;

    /**
     * 子评论
     */
    private List<CommentSon> commentSons;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    private static class CommentSon {

        /**
         * 用户id
         */
        private String userId;
        /**
         * 用户头像
         */
        private String userAvatar;
        /**
         * 用户名
         */
        private String userName;

        /**
         * 点赞
         */
        private Integer commentThumb;

        /**
         * 创建时间
         */
        private Date createTime;

        /**
         * 评语
         */
        private String commentText;

    }
}
