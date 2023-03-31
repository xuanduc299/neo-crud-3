package com.CRUD.demoCRUD.controllers;

import com.CRUD.demoCRUD.dto.ProvinceDto;
import com.CRUD.demoCRUD.dto.WardDto;
import com.CRUD.demoCRUD.service.ProvinceService;
import com.CRUD.demoCRUD.service.WardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ward")
@CrossOrigin
public class WardController {
    private final WardService wardService;

    public WardController(WardService wardService) {
        this.wardService = wardService;
    }

    @GetMapping("/")
    public List<WardDto> getAllProvince() {
        return wardService.getAll();
    }

    @GetMapping("/search/{wards_id}")
    public List<WardDto> searchById(@PathVariable Integer wards_id){
        return wardService.getById(wards_id);
    }
}
