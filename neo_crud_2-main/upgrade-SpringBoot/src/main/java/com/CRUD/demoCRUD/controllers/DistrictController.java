package com.CRUD.demoCRUD.controllers;

import com.CRUD.demoCRUD.dto.DistrictDto;
import com.CRUD.demoCRUD.dto.ProvinceDto;
import com.CRUD.demoCRUD.entity.District;
import com.CRUD.demoCRUD.entity.Ward;
import com.CRUD.demoCRUD.repository.DistrictRepository;
import com.CRUD.demoCRUD.service.DistrictService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/district")
@CrossOrigin
public class DistrictController {
    private final DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @GetMapping("/")
    public List<DistrictDto> getAllDistrict() {
        return districtService.getAll();
    }


    @GetMapping("/search/{district_id}")
    public List<DistrictDto> searchById(@PathVariable Integer district_id){
        return districtService.getById(district_id);
    }

}
