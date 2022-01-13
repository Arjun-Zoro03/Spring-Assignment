package com.zemoso.springboot.gymmanagementsystem.controller;

import com.zemoso.springboot.gymmanagementsystem.entity.Customer;
import com.zemoso.springboot.gymmanagementsystem.entity.Trainer;
import com.zemoso.springboot.gymmanagementsystem.entity.Workout;
import com.zemoso.springboot.gymmanagementsystem.service.TrainerService;
import com.zemoso.springboot.gymmanagementsystem.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/workout")
public class WorkoutController {

    private int trainerId;

    @Autowired
    private WorkoutService workoutService;

    @Autowired
    private TrainerService trainerService;

    @GetMapping("/list")
    public String listWorkouts(Model theModel, @RequestParam("trainerId") int trainerId) {

        this.trainerId = trainerId;
        List<Workout> workouts = workoutService.findAll();
        theModel.addAttribute("workouts", workouts);
        theModel.addAttribute("trainerId", trainerId);

        return "workout/workout-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Workout workout = new Workout();
        theModel.addAttribute("workout", workout);
        theModel.addAttribute("trainerId", trainerId);

        return "workout/workout-form";
    }

    @PostMapping("/save")
    public String saveWorkout(@Valid @ModelAttribute("workout") Workout workout, BindingResult bindingResult
    ){
        if(bindingResult.hasErrors())
            return "workout/workout-form";
        Trainer trainer = trainerService.findById(trainerId);
        workoutService.saveTrainerWorkout(trainer,workout);

        return "redirect:/workout/list?trainerId="+trainerId;
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("workoutId") int workoutId,
                                    Model theModel) {

        Workout workout = workoutService.findById(workoutId);
        theModel.addAttribute("workout", workout);

        return "workout/workout-form";
    }

    @GetMapping("/delete")
    public String deleteWorkout(@RequestParam("workoutId") int workoutId){
        workoutService.deleteById(workoutId);
        return "redirect:/workout/list?trainerId="+trainerId;
    }

}
