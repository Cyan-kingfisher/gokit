package org.example.usve.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.usve.dao.mapper.base.BaseTkMapper;
import org.example.usve.model.po.FollowPo;
@Mapper
public interface FollowPoMapper extends BaseTkMapper<FollowPo> {
    Integer selectFollowBack(@Param("forward") String forward, @Param("back") String back);
}