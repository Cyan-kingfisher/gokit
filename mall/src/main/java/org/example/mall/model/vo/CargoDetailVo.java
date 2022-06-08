package org.example.mall.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.mall.model.dto.CargoSon;
import org.example.mall.model.dto.CommentDto;
import org.example.mall.model.po.remotely.ReceiveAddressPo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author cyan
 * @since 2022/4/22
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CargoDetailVo {

    /**
     * id
     */
    @Id
    private Long id;

    /**
     * 货仓名称
     */
    private String warehouseName;

    /**
     * 邮费
     */
    private BigDecimal warehouseFreight;

    /**
     * 货物名称
     */
    private String cargoName;

    /**
     * 价格
     */
    private BigDecimal cargoPrice;

    /**
     * 月销售量
     */
    private Integer MonthlySales;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 总评论数
     */
    private Integer commentCounts;

    /**
     * 发货信息
     */
    private String cargoShipInfo;

    /**
     * 商品子分类
     */
    private List<CargoSon> cargoSons;

    /**
     * 收获地址
     */
    private ReceiveAddressPo receiveAddressPo;

    /**
     * 评论,默认提供两个评论
     */
    private List<CommentDto> comments;

    /**
     * 封面
     */
    private List<String> cargoImg;

    /**
     * 图文详情
     */
    private List<String> cargoText;
}
