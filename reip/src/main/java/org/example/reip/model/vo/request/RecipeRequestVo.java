package org.example.reip.model.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author cyan
 * @since 2022/4/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeRequestVo {
    String recipeName;
    String recipeDescribe;
    String recipeTips;
    String recipeTime;
    String recipeDifficulty;
    String recipeLable;
    MultipartFile recipeImage;
    List<String> materialDosage;
    List<String> materialIngredients;
    List<MultipartFile> practiceMedia;
    List<String> practiceText;
    List<String> utensilBrand;
    List<String> utensilModel;
    List<String> utensilType;
}
