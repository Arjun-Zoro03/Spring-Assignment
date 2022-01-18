package com.zemoso.springboot.gymmanagementsystem.converter;

import com.zemoso.springboot.gymmanagementsystem.dto.CustomerDTO;
import com.zemoso.springboot.gymmanagementsystem.entity.Customer;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerConverter {

    private ModelMapper mapper = new ModelMapper();

    public Customer dtoToEntity(CustomerDTO customerDTO){
        return mapper.map(customerDTO, Customer.class);
    }

    public CustomerDTO entityToDto(Customer customer) {
        return mapper.map(customer, CustomerDTO.class);
    }

    public List<CustomerDTO> entityToDto(List<Customer> customers)
    {
        List<CustomerDTO> customersDTO = new ArrayList<>();
        for(Customer customer: customers){
            CustomerDTO customerDTO= entityToDto(customer);
            customersDTO.add(customerDTO);
        }
        return  customersDTO;
    }
}
