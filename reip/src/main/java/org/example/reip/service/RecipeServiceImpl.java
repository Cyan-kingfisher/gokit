package org.example.reip.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.example.reip.annotation.SelectDataSource;
import org.example.reip.constant.RecipeStatus;
import org.example.reip.constant.error.HttpCodeEnum;
import org.example.reip.dao.mapper.*;
import org.example.reip.model.dto.MaterialDto;
import org.example.reip.model.dto.RecipeStepDto;
import org.example.reip.model.dto.UserDto;
import org.example.reip.model.dto.UtensilDto;
import org.example.reip.model.po.*;
import org.example.reip.model.vo.RecipeDetailVo;
import org.example.reip.model.vo.RecipeUpVo;
import org.example.reip.model.vo.request.RecipeRequestVo;
import org.example.reip.model.vo.request.RecipeSearchRequestVo;
import org.example.reip.model.vo.request.StringRequestVo;
import org.example.reip.model.vo.response.RecipeSimpleResponseVo;
import org.example.reip.service.remotely.UserService;
import org.example.reip.util.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author cyan
 * @since 2022/4/14
 */
@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {

    @Resource
    private FileUpService nativeFileUpUtil;

    @Autowired
    private RecipeHeaderPoMapper recipeHeaderPoMapper;

    @Autowired
    private RecipeMaterialPoMapper recipeMaterialPoMapper;

    @Autowired
    private UtensilPoMapper utensilPoMapper;

    @Autowired
    private RecipeStepPoMapper recipeStepPoMapper;

    @Autowired
    private UtensilRelatePoMapper utensilRelatePoMapper;

    @Autowired
    private UserService userService;

    @Override
    public RecipeUpVo insertRecipe(String token, RecipeRequestVo vo) {
        log.info("Recipe Up: {}", vo);
        String userId = JwtUtil.getCurrentUser(token);
        validator(userId, vo);
        int stepSize = vo.getPracticeText().size();
        String[] stepImg = new String[stepSize];
        String recipeImg = nativeFileUpUtil.getImage(vo.getRecipeImage());
        List<MultipartFile> stepMedia = vo.getPracticeMedia();
        for (int i = 0; i < stepSize; i++) {
            stepImg[i] = nativeFileUpUtil.getImage(stepMedia.get(i));
        }

        Integer recipeId = SnowIdUtil.getNextId();

        List<MaterialDto> materialResult = null;
        List<String> materialDosage = vo.getMaterialDosage();
        List<String> materialIngredients = vo.getMaterialIngredients();
        int materSize = materialDosage.size();
        if (materSize != 0) {
            materialResult = new ArrayList<>();
            for (int i = 0; i < materSize; i++) {
                RecipeMaterialPo materialPo = RecipeMaterialPo.builder().id(SnowIdUtil.getNextId()).recipeId(recipeId).materialDosage(materialDosage.get(i)).materialIngredients(materialIngredients.get(i)).build();
                recipeMaterialPoMapper.insertSelective(materialPo);
                materialResult.add(new MaterialDto(materialDosage.get(i), materialIngredients.get(i)));
            }
        }

        List<UtensilDto> utensilResult = null;
        List<String> utensilBrand = vo.getUtensilBrand();
        List<String> utensilType = vo.getUtensilType();
        List<String> utensilModel = vo.getUtensilModel();
        int utensilSize = utensilBrand.size();
        if (utensilSize != 0) {
            utensilResult = new ArrayList<>();
            for (int i = 0; i < utensilSize; i++) {
                Integer utensilId = SnowIdUtil.getNextId();
                UtensilPo utensilPo = UtensilPo.builder().id(utensilId).utensilBrand(utensilBrand.get(i)).utensilType(utensilType.get(i)).utensilModel(utensilModel.get(i)).build();
                utensilPoMapper.insertSelective(utensilPo);
                UtensilRelatePo relatePo = UtensilRelatePo.builder().recipeId(recipeId).utensilId(utensilId).id(SnowIdUtil.getNextId()).build();
                utensilRelatePoMapper.insertSelective(relatePo);
                utensilResult.add(UtensilDto.builder().utensilType(utensilType.get(i)).utensilBrand(utensilBrand.get(i)).utensilModel(utensilModel.get(i)).build());
            }
        }

        RecipeHeaderPo headerPo = RecipeHeaderPo.builder().id(recipeId).recipeLable(vo.getRecipeLable()).recipeName(vo.getRecipeName()).recipeDescribe(vo.getRecipeDescribe())
                .recipeTips(vo.getRecipeTips()).recipeTime(vo.getRecipeTime()).recipeDifficulty(vo.getRecipeDifficulty()).recipeImage(recipeImg).userId(userId).status(RecipeStatus.AUDIT.getCode()).build();
        recipeHeaderPoMapper.insertSelective(headerPo);

        List<RecipeStepDto> stepResult = new ArrayList<>();
        List<String> practiceText = vo.getPracticeText();
        for (int i = 0; i < stepSize; i++) {
            RecipeStepPo stepPo = RecipeStepPo.builder().recipeId(recipeId).id(SnowIdUtil.getNextId()).practiceMedia(stepImg[i]).practiceText(practiceText.get(i)).build();
            recipeStepPoMapper.insertSelective(stepPo);
            stepResult.add(RecipeStepDto.builder().practiceMedia(stepImg[i]).practiceText(practiceText.get(i)).build());
        }

        RecipeUpVo result = new RecipeUpVo();
        BeanUtils.copyProperties(headerPo, result);
        String recipeLable = vo.getRecipeLable();
        if (StringUtil.isNotEmpty(recipeLable)) {
            result.setRecipeLable(Arrays.asList(recipeLable.split(",")));
        }
        result.setRecipeMaterial(materialResult);
        result.setRecipeStep(stepResult);
        result.setRecipeUtensil(utensilResult);

        return result;

    }

    @Override
    public PageInfo<RecipeSimpleResponseVo> selectRecipeScreen(RecipeSearchRequestVo vo) {

        AssertUtil.isTure(vo.getPageSize()>=0, HttpCodeEnum.PAGEHELPER_ERROR);

        String searchKey0 = Optional.ofNullable(vo.getName()).orElse("");
        String searchKey1 = Optional.ofNullable(vo.getArgs()).orElse("");

        List<Integer> ids0 = recipeHeaderPoMapper.getSearchIds(searchKey0);
        List<Integer> ids1 = recipeHeaderPoMapper.getSearchIds(searchKey1);

        List<Integer> recipeIds = ids0.stream().filter(ids1::contains).distinct().collect(Collectors.toList());
        if (CollectionUtils.isEmpty(recipeIds)) {
            return null;
        }

        PageHelper.startPage(vo.getPageNum(), vo.getPageSize(),true,true,true);
        List<RecipeSimpleResponseVo> simpleRecipe = recipeHeaderPoMapper.selectAllRecipeScreen(recipeIds, vo.getOrder());
        PageInfo<RecipeSimpleResponseVo> result = new PageInfo<>(simpleRecipe);

        List<String> userIds = simpleRecipe.stream().map(RecipeSimpleResponseVo::getUserPhone).collect(Collectors.toList());
        StringRequestVo requestVo = new StringRequestVo(userIds);
        CompletableFuture<List<UserDto>> completableFuture = userService.getUserList(requestVo);
        completableFuture.thenAccept(
                userSimples -> {
                    boolean status = userSimples.size() == simpleRecipe.size();
                    AssertUtil.isTure(status, HttpCodeEnum.SEARCH_RECIPE);
                    for (int i = 0; i < userSimples.size(); i++) {
                        int index = i;
                        CompletableFuture.runAsync(
                                () -> {
                                    RecipeSimpleResponseVo simpleResponseVo = simpleRecipe.get(index);
                                    simpleResponseVo.setRecipeLables(Arrays.asList(simpleResponseVo.getRecipeLable().split(",")));
                                    simpleResponseVo.setUserAvatar(userSimples.get(index).getUserAvatar());
                                    simpleResponseVo.setUserName(userSimples.get(index).getUserName());
                                }
                        );
                    }
                }
        );
        return result;
    }

    @Override
    public RecipeDetailVo selectRecipeDetails(Integer id) {
        return null;
    }

    @Override
    @SelectDataSource
    public void guoAudit(Integer Id) {
        RecipeHeaderPo po = recipeHeaderPoMapper.selectByPrimaryKey(Id);
        po.setStatus(2);
        recipeHeaderPoMapper.updateByPrimaryKey(po);
    }


    private void validator(String userId, RecipeRequestVo vo) {
        // 用户id
        AssertUtil.isTure(StringUtil.isNotEmpty(userId), HttpCodeEnum.NO_LOGIN);
        // 原料可为空
        if (GoKitUtil.isNotNullForList(vo.getMaterialDosage(), vo.getMaterialIngredients())) {
            AssertUtil.isTure(vo.getMaterialDosage().size() == vo.getMaterialIngredients().size(), HttpCodeEnum.ARGS_ARRAY_ALIGNMENT);
        }
        // 步骤》1
        if (GoKitUtil.isNotNullForList(vo.getPracticeMedia(), vo.getPracticeText())) {
            AssertUtil.isTure(vo.getPracticeMedia().size() == vo.getPracticeText().size(), HttpCodeEnum.ARGS_ARRAY_ALIGNMENT);
        }
        AssertUtil.isTure(vo.getPracticeText().size() <=20 && vo.getPracticeText().size() >=1, HttpCodeEnum.RECIPE_UP_STEP_COUNT);
        // 厨具为空
        if (GoKitUtil.isNotNullForList(vo.getUtensilBrand(), vo.getUtensilModel(), vo.getUtensilType())) {
            AssertUtil.isTure(vo.getUtensilBrand().size() == vo.getUtensilModel().size() && vo.getUtensilModel().size() == vo.getUtensilType().size(), HttpCodeEnum.ARGS_ARRAY_ALIGNMENT);
        }
        // 封面非空
        AssertUtil.isTure(vo.getRecipeImage() != null && !vo.getRecipeImage().isEmpty(), HttpCodeEnum.FILE_NULL);
        for (MultipartFile file : vo.getPracticeMedia()) {
            AssertUtil.isTure(GoKitUtil.isNotNulForFile(file), HttpCodeEnum.FILE_NULL);
        }
    }


}
