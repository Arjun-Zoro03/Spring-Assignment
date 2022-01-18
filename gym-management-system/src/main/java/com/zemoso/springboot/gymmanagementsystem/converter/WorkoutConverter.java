package com.zemoso.springboot.gymmanagementsystem.converter;

import com.zemoso.springboot.gymmanagementsystem.dto.WorkoutDTO;
import com.zemoso.springboot.gymmanagementsystem.entity.Workout;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorkoutConverter {

    private ModelMapper mapper = new ModelMapper();

    public Workout dtoToEntity(WorkoutDTO workoutDTO){
        return mapper.map(workoutDTO, Workout.class);
    }

    public WorkoutDTO entityToDto(Workout workout) {
        return mapper.map(workout, WorkoutDTO.class);
    }

    public List<WorkoutDTO> entityToDto(List<Workout> workouts)
    {
        List<WorkoutDTO> workoutsDTO = new ArrayList<>();
        for(Workout workout: workouts){
            WorkoutDTO workoutDTO= entityToDto(workout);
            workoutsDTO.add(workoutDTO);
        }
        return  workoutsDTO;
    }
}
