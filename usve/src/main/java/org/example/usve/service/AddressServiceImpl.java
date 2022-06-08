package org.example.usve.service;

import lombok.extern.slf4j.Slf4j;
import org.example.usve.constant.error.HttpCodeEnum;
import org.example.usve.constant.error.RedisConstant;
import org.example.usve.dao.mapper.ReceiveAddressPoMapper;
import org.example.usve.model.po.ReceiveAddressPo;
import org.example.usve.model.vo.ReceiveAddressVo;
import org.example.usve.util.AssertUtil;
import org.example.usve.util.JwtUtil;
import org.example.usve.util.RedisUtil;
import org.example.usve.util.SnowIdUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author cyan
 * @since 2022/4/23
 */
@Service
@Slf4j
public class AddressServiceImpl implements AddressService {

    @Autowired
    private ReceiveAddressPoMapper receiveAddressPoMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisConstant redisConstant;

    @Override
    public List<ReceiveAddressPo> updateAddress(String token, ReceiveAddressVo vo) {
        String phone = JwtUtil.getCurrentUser(token);
        ReceiveAddressPo po = new ReceiveAddressPo();
        BeanUtils.copyProperties(vo, po);
        if (vo.getId() == null) {
            po.setUserId(phone);
            po.setAddressDefault(1);
            Long reId = SnowIdUtil.snowflakeId();
            po.setId(reId);
            resetDefaultReceiveAddress(phone, reId);
            receiveAddressPoMapper.insertSelective(po);
        } else {
            boolean flag = receiveAddressPoMapper.existsWithPrimaryKey(vo.getId());
            AssertUtil.isTure(flag, HttpCodeEnum.NO_DATA_ADDRESS);
            po.setUpdateTime(null);
            receiveAddressPoMapper.updateByPrimaryKeySelective(po);
        }
        return getBaseData(phone);
    }

    @Override
    public List<ReceiveAddressPo> selectAll(String token) {
        String phone = JwtUtil.getCurrentUser(token);
        return getBaseData(phone);
    }

    @Override
    public ReceiveAddressPo selectOne(String token, Long id) {
        String phone = JwtUtil.getCurrentUser(token);
        return receiveAddressPoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ReceiveAddressPo> deleteOne(String token, Long id) {
        String phone = JwtUtil.getCurrentUser(token);
        Integer deleteCou = receiveAddressPoMapper.deleteByPrimaryKey(id);
        log.info("deleteCount: {}", deleteCou);
        return getBaseData(phone);
    }

    @Override
    public List<ReceiveAddressPo> updateDefault(String token, Long id) {
        String phone = JwtUtil.getCurrentUser(token);
        boolean flag = receiveAddressPoMapper.existsWithPrimaryKey(id);
        AssertUtil.isTure(flag, HttpCodeEnum.NO_DATA_ADDRESS);
        Long newId = setDefaultReceiveAddress(id, 1);
        resetDefaultReceiveAddress(phone, newId);
        return getBaseData(phone);
    }

    /**
     * 设置id为redis default address, 原default为null
     *
     * @param phone
     * @param id
     */
    @Override
    public void resetDefaultReceiveAddress(String phone, Long id) {
        String key = redisConstant.getDefaultReceiveAddress() + phone;
        log.info("redis key: {}", key);
        String value = redisUtil.get(key);
        redisUtil.set(key, Long.toString(id));
        if (!StringUtils.isEmpty(value)) {
            Long addressId = Long.parseLong(value);
            if (!addressId.equals(id)) {
                setDefaultReceiveAddress(addressId, null);
            }
        }
    }

    /**
     * 设置 id record defaultStatus=value
     *
     * @param id
     * @param value
     * @return
     */
    private Long setDefaultReceiveAddress(Long id, Integer value) {
        receiveAddressPoMapper.updateAddressDefault(value, id);
        return id;
    }

    private List<ReceiveAddressPo> getBaseData(String phone) {
        Example example = new Example(ReceiveAddressPo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", phone);
        return receiveAddressPoMapper.selectByExample(example);
    }
}
