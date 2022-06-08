package org.example.mall.service;

import com.alibaba.nacos.common.utils.Pair;
import lombok.extern.slf4j.Slf4j;
import org.example.mall.annotation.SelectDataSource;
import org.example.mall.dao.mapper.CargoPoMapper;
import org.example.mall.dao.mapper.ShopLinePoMapper;
import org.example.mall.dao.mapper.WarehousePoMapper;
import org.example.mall.model.dto.ShopCartDto;
import org.example.mall.model.po.ShopLinePo;
import org.example.mall.model.po.WarehousePo;
import org.example.mall.model.vo.CargoDetail;
import org.example.mall.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author cyan
 * @since 2022/5/3
 */
@Service
@Slf4j
public class ShopCartServiceImpl implements ShopCartService {

    @Autowired
    private CargoPoMapper cargoPoMapper;

    @Autowired
    private ShopLinePoMapper shopLinePoMapper;

    @Autowired
    private WarehousePoMapper warehousePoMapper;

    @Override
    public List<ShopCartDto> selectCurrentCart(String token) {

        List<ShopCartDto> result;

        String phone = JwtUtil.getCurrentUser(JwtUtil.getToken(token));
        Example example = new Example(ShopLinePo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("shopStatus", 0);
        criteria.andEqualTo("userId", phone);
        List<ShopLinePo> linePos = shopLinePoMapper.selectByExample(example);

        if (CollectionUtils.isEmpty(linePos)) {
            return null;
        }

        int resultSize = linePos.size();

        List<Long> warehouseIds = linePos.stream().map(ShopLinePo::getWarehouseId).distinct().collect(Collectors.toList());
        List<Long> cargoIds = linePos.stream().map(ShopLinePo::getCargoId).distinct().collect(Collectors.toList());

        result = new ArrayList<>(warehouseIds.size());
        List<CargoDetail> cargoDetails = cargoPoMapper.selectDetailInfo(cargoIds);

        Map<Long, List<CargoDetail>> dataGroupByCargoDetail = cargoDetails.stream().collect(Collectors.groupingBy(CargoDetail::getId));
        Map<Long, List<ShopLinePo>> dataGroupByShopLine = linePos.stream().collect(Collectors.groupingBy(ShopLinePo::getWarehouseId));

        for (Map.Entry<Long, List<ShopLinePo>> entry : dataGroupByShopLine.entrySet()) {
            ShopCartDto cartDto = new ShopCartDto();
            WarehousePo warehousePo = warehousePoMapper.selectByPrimaryKey(entry.getKey());
            cartDto.setWarehousePo(warehousePo);
            List<ShopLinePo> originShopLine = entry.getValue();
            Pair<BigDecimal, List<ShopCartDto.CartCargo>> pair = buildShopCartDataFirst(originShopLine, dataGroupByCargoDetail);
            cartDto.setCargoList(pair.getSecond());
            BigDecimal sumPrice = pair.getFirst();
            if (sumPrice.compareTo(warehousePo.getWarehouseFreight()) < 0) {
                cartDto.setPostage(false);
                cartDto.setPriceDifference(warehousePo.getWarehouseFreight().subtract(sumPrice));
            } else {
                cartDto.setPostage(true);
            }
            result.add(cartDto);
        }
        return result;
    }

    private Pair<BigDecimal, List<ShopCartDto.CartCargo>> buildShopCartDataFirst(List<ShopLinePo> data, Map<Long, List<CargoDetail>> cargoDetailMap) {
        BigDecimal sumPrice = BigDecimal.ZERO;
        List<ShopCartDto.CartCargo> cartCargoList = data.stream().map(po -> ShopCartDto.CartCargo.builder()
                        .cargoCount(po.getCargoCount())
                        .id(po.getCargoId())
                        .cargoPrice(po.getCargoPrice().multiply(BigDecimal.valueOf(po.getCargoCount())))
                        .build())
                .collect(Collectors.toList());
        for (int i = 0; i < data.size(); i++) {
            ShopCartDto.CartCargo cartCargoDto = cartCargoList.get(i);
            ShopLinePo sip = data.get(i);
            if (sip.getCargoSonId() == null) {
                CargoDetail cargoDetail = cargoDetailMap.get(sip.getCargoId()).get(0);
                cartCargoDto.setCargoName(cargoDetail.getCargoName());
                cartCargoDto.setCargoImg(getFirstImg(cargoDetail.getCargoImg()));
            } else {
                CargoDetail cargoDetail = cargoDetailMap.get(sip.getCargoId())
                        .stream()
                        .filter(
                                po -> Objects.equals(po.getCargoSonId(), sip.getCargoSonId()))
                        .collect(Collectors.toList())
                        .get(0);
                cartCargoDto.setCargoName(cargoDetail.getCargoName());
                cartCargoDto.setCargoSonName(cargoDetail.getCargoSonName());
                cartCargoDto.setCargoImg(getFirstImg(cargoDetail.getCargoImg()));
            }
            sumPrice = sumPrice.add(cartCargoDto.getCargoPrice());
        }
        return Pair.with(sumPrice, cartCargoList);
    }

    private String getFirstImg(String img) {
        return StringUtils.isEmpty(img) ? "https://gokit.obs.cn-east-3.myhuaweicloud.com:443/mall-dbd560b0-0b21-4a14-82a3-ff789d8cdc01.png" : img.substring(0, img.indexOf(','));
    }

}
