package org.example.mall.service;

import org.example.mall.model.dto.ShopCartDto;

import java.util.List;

/**
 * @author cyan
 * @since 2022/5/3
 */
public interface ShopCartService {
    List<ShopCartDto> selectCurrentCart(String token);
}
