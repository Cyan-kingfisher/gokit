package org.example.usve.controller;

import org.example.usve.constant.error.HttpCodeEnum;
import org.example.usve.model.po.ReceiveAddressPo;
import org.example.usve.model.res.Result;
import org.example.usve.model.vo.ReceiveAddressVo;
import org.example.usve.service.AddressService;
import org.example.usve.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 收货地址
 *
 * @author cyan
 * @since 2022/4/22
 */
@RestController
@RequestMapping("/address")
public class AddressController {


    @Autowired
    private AddressService addressService;

    /**
     * 增加地址，修改地址，id为NULL时增加地址，不为NULL时修改地址
     *
     * @param vo
     * @param token token
     * @return Result<List<ReceiveAddressVo>>
     */
    @PostMapping("/simple")
    public Result<List<ReceiveAddressPo>> updateAddress(@RequestBody ReceiveAddressVo vo, @RequestHeader("Authorization") String token) {
        token = getToken(token);
        addressService.updateAddress(token, vo);
        return Result.success(addressService.selectAll(token));
    }

    /**
     * 展示地址
     *
     * @param token
     * @return Result<List<ReceiveAddressVo>>
     */
    @GetMapping("/simple")
    public Result<List<ReceiveAddressPo>> catAddress(@RequestHeader("Authorization") String token) {
        return Result.success(addressService.selectAll(getToken(token)));
    }

    /**
     * 查看某单个地址
     *
     * @param id 地址id
     * @param token token
     * @return Result<ReceiveAddressVo>
     */
    @GetMapping("/simple/{id}")
    public Result<ReceiveAddressPo> catAddress(@PathVariable("id") Long id, @RequestHeader("Authorization") String token) {
        return Result.success(addressService.selectOne(getToken(token), id));
    }

    /**
     * 删除某地址
     *
     * @param id 地址id
     * @param token token
     * @return Result<List<ReceiveAddressVo>>
     */
    @DeleteMapping("/simple/{id}")
    public Result<List<ReceiveAddressPo>> delAddress(@PathVariable("id") Long id, @RequestHeader("Authorization") String token) {
        token = getToken(token);
        addressService.deleteOne(token, id);
        return Result.success(addressService.selectAll(token));
    }

    /**
     * 设置为默认地址
     *
     * @param id 地址id
     * @param token token
     * @return Result<List<ReceiveAddressVo>>
     */
    @PostMapping("/simple/{id}")
    public Result<List<ReceiveAddressPo>> defaultAddress(@PathVariable("id") Long id, @RequestHeader("Authorization") String token) {
        token = getToken(token);
        addressService.updateDefault(token, id);
        return Result.success(addressService.selectAll(token));
    }

    private String getToken(String token) {
        AssertUtil.isTure(token.length()>6&&token.contains("Bearer"), HttpCodeEnum.PREFIX_TOKEN);
        return token.substring(6).trim();
    }

}
