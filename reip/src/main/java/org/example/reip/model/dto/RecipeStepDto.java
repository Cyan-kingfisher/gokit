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
public class RecipeStepDto {
    /**
     * 步骤图
     */
    private String practiceMedia;

    /**
     * 步骤描述
     */
    private String practiceText;
}
