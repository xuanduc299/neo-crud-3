package com.CRUD.demoCRUD.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "tb_ward")
@Table(name = "tb_ward")
@Data
public class Ward {
    @Id
    @Column
    public int ward_id;
    @Column
    public int district_id;
    @Column
    public String name;
}
