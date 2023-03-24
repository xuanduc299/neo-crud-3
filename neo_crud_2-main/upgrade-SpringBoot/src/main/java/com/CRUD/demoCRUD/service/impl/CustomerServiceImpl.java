package com.CRUD.demoCRUD.service.impl;

import com.CRUD.demoCRUD.convert.Convert;
import com.CRUD.demoCRUD.dto.CustomerDTO;
import com.CRUD.demoCRUD.dto.Response;
import com.CRUD.demoCRUD.entity.Customer;
import com.CRUD.demoCRUD.entity.Product;
import com.CRUD.demoCRUD.repository.CustomerRepository;
import com.CRUD.demoCRUD.service.CustomerService;
import com.CRUD.demoCRUD.validate.ResponseStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final Convert convert;

    public CustomerServiceImpl(CustomerRepository customerRepository, Convert convert) {
        this.customerRepository = customerRepository;
        this.convert = convert;
    }


    @Override
    public Response<List<CustomerDTO>> getAll() {
        List<Customer> customer = customerRepository.findAll();
        List<CustomerDTO> customerDto = new ArrayList<>();
        customerRepository.findAll().forEach(customers -> customerDto.add(new CustomerDTO(customers)));
        return new Response<>(customerDto);
    }

    @Override
    public Response<List<CustomerDTO>> getByName(String name) {
        List<Customer> customers = customerRepository.search(name);
        List<CustomerDTO> customerDTO = new ArrayList<>();
        customerRepository.search(name).forEach(customer -> customerDTO.add(new CustomerDTO(customer)));
        return new Response<>(customerDTO);
    }

    @Override
    public Response<CustomerDTO> getById(UUID id) {
        Customer customer = customerRepository.getCustomerById(id);
        return new Response<>(new CustomerDTO(customer),ResponseStatus.SUCCESS);
    }

    @Override
    public Response<CustomerDTO> create(CustomerDTO dto) {

        Product product = new Product();
        product.setId(dto.getProductDto().getId());

        Customer customer = new Customer();
        convert.convertDataIntoDTO(dto,customer,product);
        customer = customerRepository.save(customer);
        return new Response<>(new CustomerDTO(customer), ResponseStatus.SUCCESS);
    }

    @Override
    public Response<CustomerDTO> edit(CustomerDTO dto, UUID id) {
            return null;
    }

    @Override
    public Response<Boolean> delete(UUID id) {
        customerRepository.deleteById(id);
        return new Response<>(ResponseStatus.SUCCESS);
    }
}
