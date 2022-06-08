package org.example.mall.model.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author cyan
 * @since 2022/4/27
 */
@Data
public class CargoSon {

    /**
     * 商品子分类名称
     */
    private String sonName;

    /**
     * 商品子分类价格
     */
    private BigDecimal sonPrice;

    public CargoSon(String string) {
        if (string.contains("#")) {
            String[] arrays = string.split("#");
            this.sonPrice = new BigDecimal(arrays[1]);
        } else {
            this.sonName = string;
        }
    }
}
