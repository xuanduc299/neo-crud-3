package com.CRUD.demoCRUD.service;

import com.CRUD.demoCRUD.dto.ProvinceDto;

import java.util.List;

public interface BaseServiceAddress<T> {
    public List<T> getAll();
    public List<T> getById(Integer province_id);
}
