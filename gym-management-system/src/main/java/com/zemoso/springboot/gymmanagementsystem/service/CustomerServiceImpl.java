package com.zemoso.springboot.gymmanagementsystem.service;

import com.zemoso.springboot.gymmanagementsystem.dao.CustomerRepository;
import com.zemoso.springboot.gymmanagementsystem.dao.TrainerRepository;
import com.zemoso.springboot.gymmanagementsystem.entity.Customer;
import com.zemoso.springboot.gymmanagementsystem.entity.Trainer;
import com.zemoso.springboot.gymmanagementsystem.exceptionhandler.CustomerNotIdentifiedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void saveTrainerCustomer(Trainer trainer, Customer customer) {

            customerRepository.save(customer);
            trainer.addCustomer(customer);
            trainerRepository.save(trainer);

    }


    @Override
    public Customer findById(int id) {
        Optional<Customer> result = customerRepository.findById(id);
        Customer owner = null;
        if(result.isEmpty()){
            throw new CustomerNotIdentifiedException("Customer id is not found - " + id);
        }
        owner = result.get();
        return owner;
    }

    @Override
    public void deleteById(int customerId) {
        customerRepository.deleteById(customerId);
    }
}
