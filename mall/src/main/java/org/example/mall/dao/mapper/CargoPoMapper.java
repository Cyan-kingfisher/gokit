package org.example.mall.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.mall.dao.mapper.base.BaseTkMapper;
import org.example.mall.model.dto.ShopCartDto;
import org.example.mall.model.po.CargoPo;
import org.example.mall.model.vo.CargoCollectionVo;
import org.example.mall.model.vo.CargoDetail;

import java.util.List;

@Mapper
public interface CargoPoMapper extends BaseTkMapper<CargoPo> {
    List<CargoCollectionVo> selectAllInfo();
    List<CargoDetail> selectDetailInfo(@Param("ids") List<Long> ids);
}