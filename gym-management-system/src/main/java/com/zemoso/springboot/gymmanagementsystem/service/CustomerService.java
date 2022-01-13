package com.zemoso.springboot.gymmanagementsystem.service;

import com.zemoso.springboot.gymmanagementsystem.entity.Customer;
import com.zemoso.springboot.gymmanagementsystem.entity.Trainer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void saveTrainerCustomer(Trainer trainer, Customer customer);
    Customer findById(int id);
    void deleteById(int customerId);
}
