package com.CRUD.demoCRUD.dto;

import com.CRUD.demoCRUD.entity.Product;

import java.util.List;
import java.util.UUID;

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

    private String province;

    private String district;

    private String ward;

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
            this.setProvince(entity.getProvince());
            this.setDistrict(entity.getDistrict());
            this.setWard(entity.getWard());
        }
    }

    public String getMaSp() {
        return MaSp;
    }

    public void setMaSp(String maSp) {
        MaSp = maSp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProduct_width() {
        return product_width;
    }

    public void setProduct_width(String product_width) {
        this.product_width = product_width;
    }

    public String getProduct_height() {
        return product_height;
    }

    public void setProduct_height(String product_height) {
        this.product_height = product_height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSectors() {
        return sectors;
    }

    public void setSectors(String sectors) {
        this.sectors = sectors;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }


    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public List<CustomerDTO> getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(List<CustomerDTO> customerDto) {
        this.customerDto = customerDto;
    }
}
