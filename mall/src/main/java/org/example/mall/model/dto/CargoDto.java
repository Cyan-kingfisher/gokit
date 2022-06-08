package org.example.mall.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class CargoDto {

    /**
     * id 商品id
     */
    private Long id;

    /**
     * 货物名称
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
     * 月销售量
     */
    @Transient
    private Integer salesVolume;

}
