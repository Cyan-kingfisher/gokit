package org.example.reip.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.reip.model.dto.CommentDto;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

/**
 * @author cyan
 * @since 2022/4/12
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecipeDetailVo {

    /**
     * 登录用户头像
     */
    private String loginAvatar;

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
     * 菜谱id
     */
    private Integer id;

    /**
     * 菜谱名称
     */
    private String recipeName;

    /**
     * 烹饪时长
     */
    private String recipeTime;

    /**
     * 烹饪难度
     */
    private String recipeDifficulty;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 菜谱图片
     */
    private String recipeImage;

    /**
     * 菜谱描述
     */
    private String recipeDescribe;

    /**
     * 小贴士
     */
    private String recipeTips;

    /**
     * 作品数量
     */
    private Integer worksCount;

    /**
     * 收藏数
     */
    private Integer collectCount;

    /**
     * 作品总数
     */
    private Integer recipeWoksCount;

    /**
     * 评论总数
     */
    private Integer recipeCommentCount;

    /**
     * 标签
     */
    private List<String> recipeLable;

    /**
     * 原料
     */
    private List<Material> recipeMaterial;

    /**
     * 步骤
     */
    private List<Method> recipeMethod;

    /**
     * 作品, 默认提供《 4个作品，图片数量为0123，存在2张图片时，图片3为null。存在1张图片时，图片23为null
     */
    private List<Works> recipeWorks;

    /**
     * 评论, 默认提供《 2个评论
     */
    private List<CommentDto> recipeComment;


    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    private static class Works {
        /**
         * 作品id
         */
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
         * 点赞
         */
        private Integer worksThumb;

        /**
         * 描述
         */
        private String worksText;

        /**
         * 图片3
         */
        private String worksIm3;

        /**
         * 图片1
         */
        private String worksImg1;

        /**
         * 图片2
         */
        private String worksImg2;

        /**
         * 创建时间
         */
        private Date createTime;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    private static class Method {
        /**
         * 步骤图
         */
        private String practiceMedia;

        /**
         * 步骤描述
         */
        private String practiceText;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    private static class Material {
        /**
         * 剂量
         */
        private String materialDosage;

        /**
         * 原料名称
         */
        private String materialIngredients;
    }

}
