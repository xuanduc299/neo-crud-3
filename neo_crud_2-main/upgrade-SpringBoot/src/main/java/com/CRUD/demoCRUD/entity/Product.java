package com.CRUD.demoCRUD.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "tb_product_2")
@Table(name = "tb_product_2")
public class Product extends BaseObject{
    @Column
    private String MaSp;
    @Column
    private String name;
    @Column
    private String date;
    @Column
    private String product_width;
    @Column
    private String product_height;
    @Column
    private String color;
    @Column
    private String quantity;
    @Column
    private String brand;
    @Column
    private String material;
    @Column
    private String sectors;

    @OneToOne
    @JoinColumn(name = "province_id",referencedColumnName = "province_id")
    private Province province;
    @OneToOne
    @JoinColumn(name = "district_id",referencedColumnName = "district_id")
    private District district;
    @OneToOne
    @JoinColumn(name = "ward_id",referencedColumnName = "ward_id")
    private Ward ward;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "product")
    private List<Customer> customerList;

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

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }

    public void setSectors(String sectors) {
        this.sectors = sectors;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
