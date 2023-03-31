package com.CRUD.demoCRUD.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "tb_district")
@Table(name = "tb_district")
@Data
public class District {
    @Id
    @Column
    public int district_id;
    @Column
    public int province_id;
    @Column
    public String name;

    @OneToMany
    @JoinColumn(name = "district_id",referencedColumnName = "district_id")
    private List<Ward> wardList;


}
