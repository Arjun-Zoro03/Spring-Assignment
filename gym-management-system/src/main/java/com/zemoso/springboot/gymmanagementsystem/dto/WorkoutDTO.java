package com.zemoso.springboot.gymmanagementsystem.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class WorkoutDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int workoutId;

    @NotBlank(message = "This field is required")
    private String muscleWorked;

    @NotBlank(message = "Workout Plan cannot be left empty!!")
    private String workoutPlan;

    private int trainerId;
}
