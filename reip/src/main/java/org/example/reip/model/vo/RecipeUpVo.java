package org.example.reip.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.reip.model.dto.MaterialDto;
import org.example.reip.model.dto.RecipeStepDto;
import org.example.reip.model.dto.UtensilDto;

import java.util.List;

/**
 * @author cyan
 * @since 2022/4/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeUpVo {
    /**
     * 菜谱名称
     */
    private String recipeName;

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
     * 烹饪时长
     */
    private String recipeTime;

    /**
     * 烹饪难度
     */
    private String recipeDifficulty;

    /**
     * 标签
     */
    private List<String> recipeLable;

    /**
     * 原料
     */
    private List<MaterialDto> recipeMaterial;

    /**
     * 步骤
     */
    private List<RecipeStepDto> recipeStep;

    /**
     * 用具
     */
    private List<UtensilDto> recipeUtensil;
}
