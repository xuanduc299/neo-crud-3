package com.CRUD.demoCRUD.controllers;

import com.CRUD.demoCRUD.dto.CustomerDTO;
import com.CRUD.demoCRUD.dto.Response;
import com.CRUD.demoCRUD.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/customer")
@CrossOrigin
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public Response<List<CustomerDTO>> getAllCustomers() {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Response<CustomerDTO> getById(@PathVariable UUID id) {
        return customerService.getById(id);
    }

    @GetMapping("/search/{name}")
    public Response<List<CustomerDTO>> getByName(@PathVariable String name) {
        return customerService.getByName(name);
    }

    @PostMapping("/add")
    public Response<CustomerDTO> add(@RequestBody CustomerDTO dto) {
        return customerService.create(dto);
    }

    @PutMapping("/{id}")
    public Response<CustomerDTO> edit(@PathVariable UUID id, @RequestBody CustomerDTO dto) {
        return customerService.edit(dto, id);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        customerService.delete(id);
    }
}
