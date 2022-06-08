package org.example.mall.controller;

import org.example.mall.model.res.Result;
import org.example.mall.model.vo.CargoCollectionVo;
import org.example.mall.model.vo.CargoDetailVo;
import org.example.mall.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * cargo
 *
 * @author cyan
 * @since 2022/4/22
 */
@RequestMapping("/cargo")
@RestController
public class CargoController {

    @Autowired
    private CargoService cargoService;

    /**
     * 商店首页信息展示
     *
     * @return Result<List<CargoCollectionVo>>
     */
    @GetMapping("/all")
    public Result<List<CargoCollectionVo>> show() {
        return Result.success(cargoService.queryAllCargoCollection());
    }

    /**
     * 单个商品详情
     *
     * @param id 商品id
     * @return Result<CargoDetailVo>
     */
    @GetMapping("/{id}")
    public Result<CargoDetailVo> showSimpleCargo(@PathVariable("id") Long id) {
        return null;
    }


}
