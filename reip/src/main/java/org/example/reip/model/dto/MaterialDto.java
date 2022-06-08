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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MaterialDto {

    /**
     * 原料剂量
     */
    private String materialDosage;

    /**
     * 原料名称
     */
    private String materialIngredients;

}
