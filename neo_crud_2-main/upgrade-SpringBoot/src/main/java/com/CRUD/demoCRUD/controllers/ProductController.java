package com.CRUD.demoCRUD.controllers;

import com.CRUD.demoCRUD.dto.ProductDTO;
import com.CRUD.demoCRUD.dto.Response;
import com.CRUD.demoCRUD.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/product")
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public Response<List<ProductDTO>> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("/search/{name}")
    public Response<List<ProductDTO>> getByName(@PathVariable String name) {
        return productService.getByName(name);
    }


    @GetMapping("/{id}")
    public Response<ProductDTO> getById(@PathVariable UUID id) {
        return productService.getById(id);
    }

    @PostMapping("/add")
    public Response<ProductDTO> add(@RequestBody ProductDTO dto) {
        return productService.create(dto);
    }

    @PutMapping("/{id}")
    public Response<ProductDTO> edit(@PathVariable UUID id, @RequestBody ProductDTO dto) {
        return productService.edit(dto, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        productService.delete(id);
    }
}

