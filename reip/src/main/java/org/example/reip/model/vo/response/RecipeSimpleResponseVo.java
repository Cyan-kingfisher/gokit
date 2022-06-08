package org.example.reip.model.vo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;
import java.util.List;

/**
 * @author cyan
 * @since 2022/4/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeSimpleResponseVo {

    /**
     * 用户头像
     */
    @Transient
    private String userAvatar;

    /**
     * 用户名
     */
    @Transient
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
     * 菜谱图片
     */
    private String recipeImage;

    /**
     * 作品总数
     */
    private Integer recipeWoksCount;

    /**
     * 标签
     */
    @Transient
    private List<String> recipeLables;

    /**
     * 分类，标签, 不能包含“,”
     */
    private String recipeLable;

}
