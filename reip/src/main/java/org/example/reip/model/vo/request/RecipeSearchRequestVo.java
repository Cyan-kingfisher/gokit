package org.example.reip.model.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 搜索请求体
 *
 * @author cyan
 * @since 2022/4/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeSearchRequestVo {

    /**
     * name 搜索框的值 | 甜品
     */
    private String name;

    /**
     * 0：智能排序 1：做过最多 | 0
     */
    private Integer order;

    /**
     * 筛选参数，全部，零失败，简单 | 懒人
     */
    private String args;

    /**
     * 页码，从1开始，为0时不分页 | 1
     */
    private int pageNum;

    /**
     * 页面大小 | 10
     */
    private int pageSize;

}
