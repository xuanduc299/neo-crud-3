package com.CRUD.demoCRUD.dto;

import com.CRUD.demoCRUD.entity.District;
import com.CRUD.demoCRUD.entity.Product;
import com.CRUD.demoCRUD.entity.Province;
import com.CRUD.demoCRUD.entity.Ward;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ProductDTO extends BaseObjectDto {

    private String MaSp;

    private String name;

    private String date;

    private String product_width;

    private String product_height;

    private String color;

    private String quantity;

    private String brand;

    private String material;

    private String sectors;

    private int province;

    private int district;

    private int ward;

    private String _province;

    private String _district;

    private String _ward;

    private List<CustomerDTO> customerDto;


    public ProductDTO() {
    }

    public ProductDTO(UUID id) {
        this.setId(id);
    }

    public ProductDTO(Product entity) {
        if (entity != null) {
            this.setId(entity.getId());
            this.setMaSp(entity.getMaSp());
            this.setName(entity.getName());
            this.setDate(entity.getDate());
            this.setProduct_width(entity.getProduct_width());
            this.setProduct_height(entity.getProduct_height());
            this.setColor(entity.getColor());
            this.setQuantity(entity.getQuantity());
            this.setBrand(entity.getBrand());
            this.setMaterial(entity.getMaterial());
            this.setSectors(entity.getSectors());
            this.setProvince(entity.getProvince().getProvince_id());
            this.setDistrict(entity.getDistrict().getDistrict_id());
            this.setWard(entity.getWard().getWard_id());
            this.set_province(entity.getProvince().getName());
            this.set_district(entity.getDistrict().getName());
            this.set_ward(entity.getWard().getName());
        }
    }

}
