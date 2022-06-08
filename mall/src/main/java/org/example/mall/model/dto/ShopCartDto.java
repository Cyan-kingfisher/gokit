package org.example.mall.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.mall.model.po.WarehousePo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author cyan
 * @since 2022/4/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopCartDto {

    /**
     * 货物品类仓
     */
    private WarehousePo warehousePo;

    /**
     * 是否已享包邮，true为包邮
     */
    @Transient
    private boolean isPostage;

    /**
     * 离包邮差价
     */
    @Transient
    private BigDecimal priceDifference;

    /**
     * 购物车货物信息
     */
    private List<CartCargo> cargoList;

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Data
    public static class CartCargo {

        /**
         * 货物id
         */
        private Long id;

        /**
         * 货物名称
         */
        private String cargoName;

        /**
         * 下级分类名称
         */
        private String cargoSonName;

        /**
         * 价格
         */
        private BigDecimal cargoPrice;

        /**
         * 封面
         */
        private String cargoImg;

        /**
         * 数量
         */
        private Integer cargoCount;


    }

}
