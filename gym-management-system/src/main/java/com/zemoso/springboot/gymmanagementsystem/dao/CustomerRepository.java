package com.zemoso.springboot.gymmanagementsystem.dao;

import com.zemoso.springboot.gymmanagementsystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
