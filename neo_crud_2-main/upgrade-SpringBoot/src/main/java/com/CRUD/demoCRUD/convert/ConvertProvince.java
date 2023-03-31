package com.CRUD.demoCRUD.convert;

import com.CRUD.demoCRUD.dto.ProvinceDto;
import com.CRUD.demoCRUD.entity.Province;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ConvertProvince {
    private static ConvertDistrict transformer = new ConvertDistrict();

    public static ProvinceDto toDTO(Province entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        ProvinceDto provinceDTO = new ProvinceDto();
        provinceDTO.setProvince_id(entity.getProvince_id());
        provinceDTO.setName(entity.getName());
        provinceDTO.setDistrictList(transformer.toListDTO(entity.getDistrictList()));
        return provinceDTO;
    }

    public static List<ProvinceDto> toListDTO(List<Province> entities) {
        if (Objects.isNull(entities)) {
            return null;
        }
        List<ProvinceDto> ProvinceDTOList = new ArrayList<>();
        for (Province entity : entities) {
            ProvinceDto provinceDTO = toDTO(entity);
            ProvinceDTOList.add(provinceDTO);
        }

        return ProvinceDTOList;
    }

}
