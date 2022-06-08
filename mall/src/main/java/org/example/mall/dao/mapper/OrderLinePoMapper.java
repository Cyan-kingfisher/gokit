package org.example.mall.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.mall.dao.mapper.base.BaseTkMapper;
import org.example.mall.model.po.OrderLinePo;

@Mapper
public interface OrderLinePoMapper extends BaseTkMapper<OrderLinePo> {
}