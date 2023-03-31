package com.CRUD.demoCRUD.controllers;

import com.CRUD.demoCRUD.dto.ProductDTO;
import com.CRUD.demoCRUD.dto.ProvinceDto;
import com.CRUD.demoCRUD.dto.Response;
import com.CRUD.demoCRUD.entity.Province;
import com.CRUD.demoCRUD.service.ProvinceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/province")
@CrossOrigin
public class ProvinceController {
    private final ProvinceService provinceService;

    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @GetMapping("/")
    public List<ProvinceDto> getAllProvince() {
        return provinceService.getAll();
    }

    @GetMapping("/search/{province_id}")
    public List<ProvinceDto> searchById(@PathVariable Integer province_id){
        return provinceService.getById(province_id);
    }


}
