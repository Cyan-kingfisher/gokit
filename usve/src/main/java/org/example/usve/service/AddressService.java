package org.example.usve.service;

import org.example.usve.model.po.ReceiveAddressPo;
import org.example.usve.model.vo.ReceiveAddressVo;

import java.util.List;

/**
 * @author cyan
 * @since 2022/4/23
 */
public interface AddressService {
    List<ReceiveAddressPo> updateAddress(String token, ReceiveAddressVo vo);
    List<ReceiveAddressPo> selectAll(String token);
    ReceiveAddressPo selectOne(String token, Long id);
    List<ReceiveAddressPo> deleteOne(String token, Long id);
    List<ReceiveAddressPo> updateDefault(String token, Long id);
    void resetDefaultReceiveAddress(String phone, Long id);
}
