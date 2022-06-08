package org.example.mall.controller;

import org.example.mall.model.dto.ShopCartDto;
import org.example.mall.model.res.Result;
import org.example.mall.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author cyan
 * @since 2022/4/22
 */
@RestController
public class ShopCartController {

    @Autowired
    private ShopCartService shopCartService;

    /**
     * 获取购物车信息
     *
     * @param token token
     * @return Result<List<ShopCartDto>>
     */
    @GetMapping("/shopping_cart")
    public Result<List<ShopCartDto>> shopCartShow(@RequestHeader("Authorization") String token) {
        return Result.success(shopCartService.selectCurrentCart(token));
    }

}
