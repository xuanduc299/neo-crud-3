package com.CRUD.demoCRUD.service;

import com.CRUD.demoCRUD.dto.Response;

import java.util.List;
import java.util.UUID;

public interface BaseService<T> {
    Response<List<T>> getAll();
    Response<List<T>> getByName(String name);
    Response<T> getById(UUID id);
    Response<T> create(T dto);
    Response<T> edit(T dto, UUID id);

    Response<Boolean> delete(UUID id);
}
