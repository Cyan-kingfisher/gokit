package org.example.usve.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.usve.dao.mapper.base.BaseTkMapper;
import org.example.usve.model.dto.UserDto;
import org.example.usve.model.po.UserPo;
import org.example.usve.model.vo.UserVo;

import java.util.List;

@Mapper
public interface UserPoMapper extends BaseTkMapper<UserPo> {

    void updateOne(@Param("vo") UserVo vo);

    List<UserDto> selectAllByIds(@Param("vl") List<String> vl);

    List<UserDto> selectFollowUserInfo(@Param("userId") String userId);

    List<UserDto> selectFansUserInfo(@Param("userId") String userId);
}