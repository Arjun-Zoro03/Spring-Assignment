package com.zemoso.springboot.gymmanagementsystem.service;

import com.zemoso.springboot.gymmanagementsystem.dao.WorkoutRepository;
import com.zemoso.springboot.gymmanagementsystem.entity.Customer;
import com.zemoso.springboot.gymmanagementsystem.entity.Trainer;
import com.zemoso.springboot.gymmanagementsystem.entity.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutServiceImpl implements WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Override
    public List<Workout> findAll() {
        return workoutRepository.findAll();
    }

    @Override
    public void saveTrainerWorkout(Trainer trainer, Workout workout) {
        if(!trainer.getWorkouts().contains(workout))
            trainer.addWorkout(workout);
        workout.setTrainerId(trainer.getTrainerId());
        workoutRepository.save(workout);

    }

    @Override
    public void deleteById(int workoutId) {
        workoutRepository.deleteById(workoutId);
    }

    @Override
    public Workout findById(int workoutId) {
        Optional<Workout> result = workoutRepository.findById(workoutId);
        Workout owner = null;
        if(result.isEmpty()){
            throw new RuntimeException("Owner id is not found - " + workoutId);
        }
        owner = result.get();
        return owner;
    }

}
