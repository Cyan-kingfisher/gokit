package org.example.reip.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

/**
 * @author cyan
 * @since 2022/4/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UtensilDto {

    /**
     * 用具品牌
     */
    private String utensilBrand;

    /**
     * 用具型号
     */
    private String utensilModel;

    /**
     * 用具类型
     */
    private String utensilType;

}
