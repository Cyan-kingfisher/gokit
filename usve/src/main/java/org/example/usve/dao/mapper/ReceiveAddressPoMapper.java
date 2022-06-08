package org.example.usve.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.usve.dao.mapper.base.BaseTkMapper;
import org.example.usve.model.po.ReceiveAddressPo;

@Mapper
public interface ReceiveAddressPoMapper extends BaseTkMapper<ReceiveAddressPo> {
    void updateAddressDefault(@Param("flag") Integer flag, @Param("id") Long id);
}