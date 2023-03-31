package com.CRUD.demoCRUD.convert;

import com.CRUD.demoCRUD.dto.DistrictDto;
import com.CRUD.demoCRUD.entity.District;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ConvertDistrict {
    private static ConvertWard transformer = new ConvertWard();


    public static DistrictDto toDTO(District entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        DistrictDto districtDto = new DistrictDto();
        districtDto.setProvince_id(entity.getProvince_id());
        districtDto.setDistrict_id(entity.getDistrict_id());
        districtDto.setName(entity.getName());
        districtDto.setWardListDto(transformer.toListDTO(entity.getWardList()));
        return districtDto;
    }

    public static List<DistrictDto> toListDTO(List<District> entities) {
        if (Objects.isNull(entities)) {
            return null;
        }
        List<DistrictDto> WardDTOList = new ArrayList<>();
        for (District entity : entities) {
            DistrictDto districtDTO = toDTO(entity);
            WardDTOList.add(districtDTO);
        }
        return WardDTOList;
    }

}
