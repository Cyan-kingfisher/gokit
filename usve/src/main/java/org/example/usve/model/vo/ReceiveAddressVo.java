package org.example.usve.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cyan
 * @since 2022/4/22
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReceiveAddressVo {

    /**
     * id
     */
    private Long id;

    /**
     * 姓名
     */
    private String addressName;

    /**
     * 11位手机号
     */
    private String addressPhone;

    /**
     * 省市区街道 ,分割
     */
    private String addressSuper;

    /**
     * 详细地址
     */
    private String addressDetail;

}
