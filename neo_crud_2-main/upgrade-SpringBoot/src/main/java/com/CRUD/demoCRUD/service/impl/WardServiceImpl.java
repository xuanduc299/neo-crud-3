package com.CRUD.demoCRUD.service.impl;

import com.CRUD.demoCRUD.convert.ConvertWard;
import com.CRUD.demoCRUD.dto.WardDto;
import com.CRUD.demoCRUD.entity.Ward;
import com.CRUD.demoCRUD.repository.WardRepository;
import com.CRUD.demoCRUD.service.WardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WardServiceImpl implements WardService {
    private  final WardRepository wardRepository;
    private  final ConvertWard convert;
    public WardServiceImpl(WardRepository wardRepository, ConvertWard convert) {
        this.wardRepository = wardRepository;
        this.convert = convert;
    }
    @Override
    public List<WardDto> getAll() {
        List<Ward> ward = wardRepository.findAll();
        List<WardDto> wardDto = convert.toListDTO(ward);
        return  wardDto;
    }
    @Override
    public List<WardDto> getById(Integer wards_id) {
        List<Ward> ward = wardRepository.searchId(wards_id);
        List<WardDto> wardDto = convert.toListDTO(ward);
        return wardDto;
    }
}
