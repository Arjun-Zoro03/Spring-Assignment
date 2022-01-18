package com.zemoso.springboot.gymmanagementsystem.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "workout")
@Getter @Setter
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int workoutId;

    @NotBlank(message = "This field is required")
    @Column(name = "muscle_worked")
    private String muscleWorked;

    @NotBlank(message = "Workout Plan cannot be left empty!!")
    @Column(name = "workout_plan")
    private String workoutPlan;

    @Column(name = "trainer_id")
    private int trainerId;

    @Override
    public String toString() {
        return "Workout{" +
                "id=" + workoutId +
                ", muscleWorked='" + muscleWorked + '\'' +
                '}';
    }
}
