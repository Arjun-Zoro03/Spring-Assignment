package com.zemoso.springboot.gymmanagementsystem.dao;

import com.zemoso.springboot.gymmanagementsystem.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {
}
