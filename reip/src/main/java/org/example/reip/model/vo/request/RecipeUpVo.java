package org.example.reip.model.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author cyan
 * @since 2022/5/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeUpVo {

    /**
     *
     */
    String recipeName;

    /**
     *
     */
    String recipeDescribe;

    /**
     *
     */
    String recipeTips;

    /**
     *
     */
    String recipeTime;

    /**
     *
     */
    String recipeDifficulty;

    /**
     *
     */
    String recipeLable;

    /**
     *
     */
    MultipartFile recipeImage;

    /**
     *
     */
    String[] materialDosage;

    /**
     *
     */
    String[] materialIngredients;

    /**
     *
     */
    MultipartFile[] practiceMedia;

    /**
     *
     */
    String[] practiceText;

    /**
     *
     */
    String[] utensilBrand;

    /**
     *
     */
    String[] utensilModel;

    /**
     * 厨房用具数组
     */
    String[] utensilType;


}

/**
 * 菜谱上传
 *
 * 出现多个对象时，以下数组类型的参数可出现多次
 * 对应的内部参数数量需一致，比如：
 * 请求信息中出现
 * 3个materialDosage，就必须出现3个materialIngredients
 *
 * 单个原料
 * materialDosage:string 剂量，原料数组
 * materialIngredients:string 名称，原料数组
 *
 * 单个步骤
 * practiceMedia:file 图片，步骤数组
 * practiceText:string 描述，步骤数组
 *
 * 单个厨房用具
 * utensilBrand:string 品牌，厨房用具数组
 * utensilModel:string 型号，厨房用具数组
 * utensilType:string 类型，厨房用具数组
 *
 * @param recipeName 菜谱名称
 * @param recipeDescribe 菜谱描述
 * @param recipeTips 小贴士
 * @param recipeTime 烹饪时间
 * @param recipeDifficulty 烹饪难度
 * @param recipeLable 分类标签，多个标签以英文逗号隔开
 * @param recipeImage 菜谱封面
 * @param materialDosage 剂量，原料数组
 * @param materialIngredients 名称，原料数组
 * @param practiceMedia 图片，步骤数组
 * @param practiceText 描述，步骤数组
 * @param utensilBrand 品牌，厨房用具数组
 * @param utensilModel 型号，厨房用具数组
 * @param utensilType 类型，厨房用具数组
 * @return Result<RecipeUpVo>

 */
