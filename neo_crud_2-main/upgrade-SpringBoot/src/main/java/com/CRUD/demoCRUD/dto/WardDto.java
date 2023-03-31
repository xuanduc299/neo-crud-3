package com.CRUD.demoCRUD.dto;


import com.CRUD.demoCRUD.entity.Ward;
import lombok.Data;

@Data
public class WardDto {
    public int ward_id;
    public int district_id;
    public String name;

}
