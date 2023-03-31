package com.CRUD.demoCRUD.dto;

import com.CRUD.demoCRUD.entity.Province;
import lombok.Data;

import java.util.List;

@Data
public class ProvinceDto {
    private int province_id;
    private String name;

    private List<DistrictDto> districtList;

    public ProvinceDto(Province entity) {
        if (entity != null) {
            this.setProvince_id(entity.getProvince_id());
            this.setName(entity.getName());
        }
    }

    public ProvinceDto() {

    }
}
