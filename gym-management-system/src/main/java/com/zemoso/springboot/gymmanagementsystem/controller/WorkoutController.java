package com.zemoso.springboot.gymmanagementsystem.controller;

import com.zemoso.springboot.gymmanagementsystem.converter.TrainerConverter;
import com.zemoso.springboot.gymmanagementsystem.converter.WorkoutConverter;
import com.zemoso.springboot.gymmanagementsystem.dto.TrainerDTO;
import com.zemoso.springboot.gymmanagementsystem.dto.WorkoutDTO;
import com.zemoso.springboot.gymmanagementsystem.entity.Workout;
import com.zemoso.springboot.gymmanagementsystem.service.TrainerService;
import com.zemoso.springboot.gymmanagementsystem.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/workouts")
public class WorkoutController {

    private WorkoutConverter workoutConverter = new WorkoutConverter();

    @Autowired
    private WorkoutService workoutService;

    private int trainerId;

    private TrainerConverter trainerConverter = new TrainerConverter();

    @Autowired
    private TrainerService trainerService;

    @GetMapping("/list")
    public String listWorkouts(@RequestParam("id") int id, Model theModel) {

        this.trainerId = id;
        List<WorkoutDTO> workouts = workoutConverter.entityToDto(workoutService.findAll());
        theModel.addAttribute("workouts", workouts);
        theModel.addAttribute("id", id);

        return "workout/workout-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(@RequestParam("trainerId") int trainerId, Model theModel) {

        WorkoutDTO workout = workoutConverter.entityToDto(new Workout());
        theModel.addAttribute("workout", workout);
        theModel.addAttribute("trainerId", trainerId);

        return "workout/workout-form";
    }

    @PostMapping("/save")
    public String saveWorkout(@Valid @ModelAttribute("workout") WorkoutDTO workout, BindingResult bindingResult
    ){
        if(bindingResult.hasErrors())
            return "workout/workout-form";
        TrainerDTO trainer = trainerConverter.entityToDto(trainerService.findById(trainerId));
        workoutService.saveTrainerWorkout(trainerConverter.dtoToEntity(trainer),
                workoutConverter.dtoToEntity(workout));

        return "redirect:/workouts/list?id="+trainerId;
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("workoutId") int workoutId,
                                    Model theModel) {

        theModel.addAttribute("trainerId", trainerId);
        WorkoutDTO workout = workoutConverter.entityToDto(workoutService.findById(workoutId));
        theModel.addAttribute("workout", workout);

        return "workout/workout-form";
    }

    @GetMapping("/delete")
    public String deleteWorkout(@RequestParam("workoutId") int workoutId){
        workoutService.deleteById(workoutId);
        return "redirect:/workouts/list?id="+trainerId;
    }

}
