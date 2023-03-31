package com.CRUD.demoCRUD.service.impl;

import com.CRUD.demoCRUD.convert.ConvertProvince;
import com.CRUD.demoCRUD.dto.ProvinceDto;
import com.CRUD.demoCRUD.entity.Province;
import com.CRUD.demoCRUD.repository.ProvinceRepository;
import com.CRUD.demoCRUD.service.ProvinceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    private final ProvinceRepository provinceRepository;
    private final ConvertProvince convert;

    public ProvinceServiceImpl(ProvinceRepository provinceRepository, ConvertProvince convert) {
        this.provinceRepository = provinceRepository;
        this.convert = convert;
    }

    @Override
    public List<ProvinceDto> getAll() {
        List<Province> province = provinceRepository.findAll();
        List<ProvinceDto> provinceDto = convert.toListDTO(province);
        return provinceDto;
    }

    @Override
    public List<ProvinceDto> getById(Integer province_id){
//        List<Province> province = provinceRepository.searchId(province_id);
//        List<ProvinceDto> provinceDto = new ArrayList<>();
//        provinceRepository.searchId(province_id).forEach(provinces -> provinceDto.add(new ProvinceDto(provinces)));
        List<Province> province = provinceRepository.searchId(province_id);
        List<ProvinceDto> provinceDto = convert.toListDTO(province);
        return provinceDto;
    }
}
