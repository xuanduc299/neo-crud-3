package com.CRUD.demoCRUD.dto;

import com.CRUD.demoCRUD.convert.Convert;
import com.CRUD.demoCRUD.entity.District;
import lombok.Data;

import java.util.List;

@Data
public class DistrictDto {
    public int district_id;
    public int province_id;
    public String name;

    private List<WardDto> wardListDto;

    public DistrictDto() {
    }

    public DistrictDto(District entity) {
        if(entity!=null) {
            this.setDistrict_id(entity.getDistrict_id());
            this.setProvince_id(entity.getProvince_id());
            this.setName(entity.getName());
        }
    }
}
