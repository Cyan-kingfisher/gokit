package org.example.reip.service;

import com.github.pagehelper.PageInfo;
import org.example.reip.model.vo.RecipeDetailVo;
import org.example.reip.model.vo.RecipeUpVo;
import org.example.reip.model.vo.request.RecipeRequestVo;
import org.example.reip.model.vo.request.RecipeSearchRequestVo;
import org.example.reip.model.vo.response.RecipeSimpleResponseVo;

/**
 * @author cyan
 * @since 2022/4/14
 */
public interface RecipeService {

    RecipeUpVo insertRecipe(String token, RecipeRequestVo vo);

    PageInfo<RecipeSimpleResponseVo> selectRecipeScreen(RecipeSearchRequestVo vo);

    RecipeDetailVo selectRecipeDetails(Integer id);

    void guoAudit(Integer Id);

}
