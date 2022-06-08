package org.example.mall.service;

import org.example.mall.model.vo.CargoCollectionVo;

import java.util.List;

/**
 * @author cyan
 * @since 2022/4/27
 */
public interface CargoService {
    List<CargoCollectionVo> queryAllCargoCollection();
}
