package org.example.reip.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.reip.dao.mapper.base.BaseTkMapper;
import org.example.reip.model.po.RecipeHeaderPo;
import org.example.reip.model.vo.response.RecipeSimpleResponseVo;

import java.util.List;

@Mapper
public interface RecipeHeaderPoMapper extends BaseTkMapper<RecipeHeaderPo> {
    List<RecipeSimpleResponseVo> selectAllRecipeScreen(@Param("vl") List<Integer> vl, @Param("ord") Integer ord);
    List<Integer> selectAllRecipeWorksCount(@Param("vl") List<Integer> vl);
    List<Integer> getSearchIds(@Param("search") String search);
}