package com.zemoso.springboot.gymmanagementsystem.service;

import com.zemoso.springboot.gymmanagementsystem.dao.TrainerRepository;
import com.zemoso.springboot.gymmanagementsystem.entity.Customer;
import com.zemoso.springboot.gymmanagementsystem.entity.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerServiceImpl implements TrainerService{

    @Autowired
    private TrainerRepository trainerRepository;

    @Override
    public Trainer findById(int id) {
        return trainerRepository.getById(id);
    }


}
