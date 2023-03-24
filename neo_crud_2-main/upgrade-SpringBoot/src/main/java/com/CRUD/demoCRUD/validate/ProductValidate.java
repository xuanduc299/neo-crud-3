package com.CRUD.demoCRUD.validate;

import com.CRUD.demoCRUD.Constants;
import com.CRUD.demoCRUD.dto.ProductDTO;
import com.CRUD.demoCRUD.repository.CustomerRepository;
import com.CRUD.demoCRUD.repository.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ProductValidate {
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    public ProductValidate(ProductRepository productRepository, CustomerRepository customerRepository) {
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    public ResponseStatus validateProduct(UUID productId, ProductDTO dto) {
        if (productId != null && !productRepository.existsById(productId)) {
            return ResponseStatus.EMPLOYEE_ID_NO_EXIST;
        }
        ResponseStatus status = validateName(productId, dto.getName());
        if (status != ResponseStatus.SUCCESS) {
            return status;
        }
        if (!StringUtils.hasText(dto.getName())) {
            return ResponseStatus.EMPLOYEE_NAME_IS_NULL;
        }

        status = validateDate(dto.getDate());
        if (status != ResponseStatus.SUCCESS) {
            return status;
        }
        status = validateColor(dto.getColor());
        if (status != ResponseStatus.SUCCESS) {
            return status;
        }
        status = validateQuantity(dto.getQuantity());
        if (status != ResponseStatus.SUCCESS) {
            return status;
        }
        status = validateBrand(dto.getBrand());
        if (status != ResponseStatus.SUCCESS) {
            return status;
        }
        status = validateMaterial(dto.getMaterial());
        if (status != ResponseStatus.SUCCESS) {
            return status;
        }
        status = validateQuantity(dto.getQuantity());
        if (status != ResponseStatus.SUCCESS) {
            return status;
        }
        return ResponseStatus.SUCCESS;
    }

    public ResponseStatus validateName(UUID productId, String name) {
        if (!StringUtils.hasText(name)) {
            return ResponseStatus.EMPLOYEE_CODE_IS_NULL;
        }
        Pattern pattern = Pattern.compile(Constants.REGEX_STRING);
        Matcher matcher = pattern.matcher(name);
        if (!matcher.find()) {
            return ResponseStatus.EMPLOYEE_CODE_WRONG_FORMAT;
        }
        if (productId == null && productRepository.existsByName(name)) {
            return ResponseStatus.EMPLOYEE_CODE_IS_EXIST;
        }
        return ResponseStatus.SUCCESS;
    }

    public ResponseStatus validateDate(String date) {
        Pattern pattern = Pattern.compile(Constants.REGEX_STRING);
        Matcher matcher = pattern.matcher(date);

        if (!matcher.find()) {
            return ResponseStatus.EMPLOYEE_CODE_WRONG_FORMAT;
        }
        return ResponseStatus.SUCCESS;
    }

    public ResponseStatus validateColor(String color) {
        Pattern pattern = Pattern.compile(Constants.REGEX_STRING);
        Matcher matcher = pattern.matcher(color);

        if (!matcher.find()) {
            return ResponseStatus.EMPLOYEE_CODE_WRONG_FORMAT;
        }
        return ResponseStatus.SUCCESS;
    }

    public ResponseStatus validateQuantity(String quantity) {
        Pattern pattern = Pattern.compile(Constants.REGEX_STRING);
        Matcher matcher = pattern.matcher(quantity);

        if (!matcher.find()) {
            return ResponseStatus.EMPLOYEE_CODE_WRONG_FORMAT;
        }
        return ResponseStatus.SUCCESS;
    }

    public ResponseStatus validateBrand(String brand) {
        Pattern pattern = Pattern.compile(Constants.REGEX_STRING);
        Matcher matcher = pattern.matcher(brand);

        if (!matcher.find()) {
            return ResponseStatus.EMPLOYEE_CODE_WRONG_FORMAT;
        }
        return ResponseStatus.SUCCESS;
    }

    public ResponseStatus validateMaterial(String material) {
        Pattern pattern = Pattern.compile(Constants.REGEX_STRING);
        Matcher matcher = pattern.matcher(material);

        if (!matcher.find()) {
            return ResponseStatus.EMPLOYEE_CODE_WRONG_FORMAT;
        }
        return ResponseStatus.SUCCESS;
    }

}
