package com.CRUD.demoCRUD.entity;

import com.CRUD.demoCRUD.dto.DistrictDto;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "tb_province")
@Table(name = "tb_province")
@Data
public class Province {
    @Id
    @Column
    private int province_id;
    @Column
    private String name;
    @OneToMany
    @JoinColumn(name = "province_id",referencedColumnName = "province_id")
    private List<District> districtList;
}
