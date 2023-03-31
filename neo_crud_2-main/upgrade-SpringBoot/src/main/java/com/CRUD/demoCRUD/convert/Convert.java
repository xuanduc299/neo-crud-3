package com.CRUD.demoCRUD.convert;

import com.CRUD.demoCRUD.dto.*;
import com.CRUD.demoCRUD.entity.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Component
public class Convert {
    public void convertDataIntoDTO(ProductDTO productDTO, Product product){
        product.setMaSp(productDTO.getMaSp());
        product.setName(productDTO.getName());
        product.setDate(productDTO.getDate());
        product.setProduct_width(productDTO.getProduct_width());
        product.setProduct_height(productDTO.getProduct_height());
        product.setColor(productDTO.getColor());
        product.setQuantity(productDTO.getQuantity());
        product.setBrand(productDTO.getBrand());
        product.setMaterial(productDTO.getMaterial());
        product.setSectors(productDTO.getSectors());
        Province province = new Province();
        District district = new District();
        Ward ward = new Ward();
        province.setProvince_id(productDTO.getProvince());
        product.setProvince(province);
        district.setDistrict_id(productDTO.getDistrict());
        product.setDistrict(district);
        ward.setWard_id(productDTO.getWard());
        product.setWard(ward);

    }

    public void convertDataIntoDTO(CustomerDTO customerDTO, Customer customer,Product product){
        customer.setMakh(customerDTO.getMakh());
        customer.setName(customerDTO.getName());
        customer.setAge(customerDTO.getAge());
        customer.setAddress(customerDTO.getAddress());
        customer.setDate(customerDTO.getDate());
        customer.setQuantity(customerDTO.getQuantity());
        customer.setSectors(customerDTO.getSectors());
        customer.setProduct(product);
    }

    public void convertDataIntoDTO( District district , DistrictDto districtDto, Ward ward) {
        district.setDistrict_id(districtDto.getDistrict_id());
        district.setProvince_id(districtDto.getProvince_id());
        district.setName(districtDto.getName());
//        district.setWardList(districtDto.getWardListDto());
    }

}
