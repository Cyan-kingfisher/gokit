package org.example.reip.controller;

import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.example.reip.constant.error.HttpCodeEnum;
import org.example.reip.model.res.Result;
import org.example.reip.model.vo.RecipeDetailVo;
import org.example.reip.model.vo.RecipeSourceVo;
import org.example.reip.model.vo.RecipeUpVo;
import org.example.reip.model.vo.request.RecipeRequestVo;
import org.example.reip.model.vo.request.RecipeSearchRequestVo;
import org.example.reip.service.FileUpService;
import org.example.reip.service.RecipeService;
import org.example.reip.util.AssertUtil;
import org.example.reip.util.ObsImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜谱API
 * 
 * @author cyan
 * @since 2022/4/11
 */
@RestController
@Slf4j
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    /**
     * 菜谱筛选
     *
     * @param requestVo 请求体
     * @return Result<PageInfo<RecipeSourceVo>>
     */
    @GetMapping("/{pageSize}/{pageNum}")
    public Result<PageInfo<RecipeSourceVo>> recipeSearch(RecipeSearchRequestVo requestVo) {
        return Result.success(recipeService.selectRecipeScreen(requestVo));
    }

    /**
     * 菜谱详情
     *
     * @param id 菜谱id
     * @return Result<RecipeDetailVo>
     */
    @GetMapping("/{id}")
    public Result<RecipeDetailVo> recipeDetails(@PathVariable Integer id) {
        return Result.success(recipeService.selectRecipeDetails(id));
    }

    /**
     * 菜谱上传
     *
     * @param token
     * @return
     */
    @PutMapping(value = "/upload", headers = "content-type=multipart/form-data")
    public Result<RecipeUpVo> recipeUpload(@RequestHeader("Authorization") String token, RecipeRequestVo vo) {
        AssertUtil.isTure(token.length()>6&&token.contains("Bearer"), HttpCodeEnum.PREFIX_TOKEN);
        token = token.substring(6).trim();
        RecipeUpVo result = recipeService.insertRecipe(token, vo);
        return Result.success(result);
    }

    @PostMapping("/audit/{id}")
    public Result<Object> audit(@PathVariable Integer id) {
        recipeService.guoAudit(id);
        return Result.success();
    }

    @Resource
    private FileUpService nativeFileUpUtil;

    @PostMapping(value = "/test", headers = "content-type=multipart/form-data")
    public Result upFile(List<MultipartFile> file) {
        List<String> ars = new ArrayList<>(file.size());
        for (MultipartFile ii: file) {
            String temp = nativeFileUpUtil.getImage(ii);
            ars.add(temp);
        }
        log.info("ars: {}", ars);
        return Result.success();
    }

}
