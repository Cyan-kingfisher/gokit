package org.example.mall.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author cyan
 * @since 2022/5/3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargoDetail {

    /**
     * id
     */
    private Long id;

    /**
     * 货仓id
     */
    private Long warehouseId;

    /**
     * 货物名称 空格分割名字与一包大小
     */
    private String cargoName;

    /**
     * 价格
     */
    private BigDecimal cargoPrice;

    /**
     * 封面
     */
    private String cargoImg;

    /**
     * 发货信息
     */
    private String cargoShipInfo;

    /**
     * 图文详情
     */
    private String cargoText;

    /**
     * 商品子类id
     */
    private Integer cargoSonId;

    /**
     * 商品id
     */
    private Long cargoId;

    /**
     * 名称+剂量，空格分割
     */
    private String cargoSonName;

    /**
     * 价格
     */
    private BigDecimal cargoSonPrice;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
