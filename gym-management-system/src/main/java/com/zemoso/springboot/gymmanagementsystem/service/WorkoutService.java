package com.zemoso.springboot.gymmanagementsystem.service;


import com.zemoso.springboot.gymmanagementsystem.entity.Trainer;
import com.zemoso.springboot.gymmanagementsystem.entity.Workout;

import java.util.List;

public interface WorkoutService {
    List<Workout> findAll();
    void saveTrainerWorkout(Trainer trainer, Workout workout);
    void deleteById(int workoutId);
    Workout findById(int workoutId);
}
