package org.example.mall.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.mall.model.dto.CargoDto;

import java.util.List;

/**
 * @author cyan
 * @since 2022/4/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargoCollectionVo {

    /**
     * 货仓名称
     */
    private String warehouseName;

    /**
     * 该货仓内商品
     */
    private List<CargoDto> cargoDtos;

}
