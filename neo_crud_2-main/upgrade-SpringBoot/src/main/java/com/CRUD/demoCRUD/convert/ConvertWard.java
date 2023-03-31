package com.CRUD.demoCRUD.convert;

import com.CRUD.demoCRUD.dto.WardDto;
import com.CRUD.demoCRUD.entity.Ward;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class ConvertWard {

    public static WardDto toDTO(Ward entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        WardDto wardDTO = new WardDto();
        wardDTO.setWard_id(entity.getWard_id());
        wardDTO.setDistrict_id(entity.getDistrict_id());
        wardDTO.setName(entity.getName());

        return wardDTO;
    }

    public static List<WardDto> toListDTO(List<Ward> entities) {
        if (Objects.isNull(entities)) {
            return null;
        }
        List<WardDto> WardDTOList = new ArrayList<>();
        for (Ward entity : entities) {
            WardDto districtDTO = toDTO(entity);
            WardDTOList.add(districtDTO);
        }
        return WardDTOList;
    }

}
