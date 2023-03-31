package com.CRUD.demoCRUD.service.impl;

import com.CRUD.demoCRUD.convert.Convert;
import com.CRUD.demoCRUD.convert.ConvertDistrict;
import com.CRUD.demoCRUD.dto.DistrictDto;
import com.CRUD.demoCRUD.dto.ProvinceDto;
import com.CRUD.demoCRUD.entity.District;
import com.CRUD.demoCRUD.entity.Province;
import com.CRUD.demoCRUD.repository.DistrictRepository;
import com.CRUD.demoCRUD.repository.ProvinceRepository;
import com.CRUD.demoCRUD.service.DistrictService;
import com.CRUD.demoCRUD.service.ProvinceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    private final DistrictRepository districtRepository;
    private final ConvertDistrict convert;

    public DistrictServiceImpl(DistrictRepository districtRepository, ConvertDistrict convert) {
        this.districtRepository = districtRepository;
        this.convert = convert;
    }


    @Override
    public List<DistrictDto> getAll() {
        List<District> district = districtRepository.findAll();
        List<DistrictDto> districtDto = convert.toListDTO(district);
        return  districtDto;
    }

    @Override
    public List<DistrictDto> getById(Integer district_id) {
        List<District> district = districtRepository.searchId(district_id);
        List<DistrictDto> districtDto = convert.toListDTO(district);
        return districtDto;
    }
}
