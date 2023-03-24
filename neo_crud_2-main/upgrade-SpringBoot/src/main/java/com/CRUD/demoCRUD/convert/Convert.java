package com.CRUD.demoCRUD.convert;

import com.CRUD.demoCRUD.dto.CustomerDTO;
import com.CRUD.demoCRUD.dto.ProductDTO;
import com.CRUD.demoCRUD.entity.Customer;
import com.CRUD.demoCRUD.entity.Product;
import org.springframework.stereotype.Component;

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
        product.setProvince(productDTO.getProvince());
        product.setDistrict(productDTO.getDistrict());
        product.setVillage(productDTO.getVillage());

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
}
