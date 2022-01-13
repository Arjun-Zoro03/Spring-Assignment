package com.zemoso.springboot.gymmanagementsystem.dao;

import com.zemoso.springboot.gymmanagementsystem.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Integer> {
}
