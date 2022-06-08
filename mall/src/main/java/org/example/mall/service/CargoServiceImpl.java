package org.example.mall.service;

import org.example.mall.annotation.SelectDataSource;
import org.example.mall.config.DataSourceType;
import org.example.mall.dao.mapper.CargoPoMapper;
import org.example.mall.model.dto.CargoDto;
import org.example.mall.model.vo.CargoCollectionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author cyan
 * @since 2022/4/27
 */
@Service
public class CargoServiceImpl implements CargoService {


    @Autowired
    private CargoPoMapper cargoPoMapper;


    @Override
    @SelectDataSource(DataSourceType.Type.SLAVE)
    public List<CargoCollectionVo> queryAllCargoCollection() {
        List<CargoCollectionVo> result = cargoPoMapper.selectAllInfo();
        List<CargoDto> coreData = result.stream()
                .flatMap(po -> po.getCargoDtos().stream())
                .collect(Collectors.toList());
        List<Long> cargoIds = coreData.stream().map(CargoDto::getId).collect(Collectors.toList());
        int dataSize = coreData.size();
        for (int i = 0; i < dataSize; i++) {
            CargoDto cargoDto = coreData.get(i);
            String img = getFirstImg(cargoDto.getCargoImg());
            cargoDto.setCargoImg(img);
            cargoDto.setSalesVolume(0);
        }
        return result;
    }

    private String getFirstImg(String img) {
        return StringUtils.isEmpty(img) ? "https://gokit.obs.cn-east-3.myhuaweicloud.com:443/mall-dbd560b0-0b21-4a14-82a3-ff789d8cdc01.png" : img.substring(0, img.indexOf(','));
    }

}
