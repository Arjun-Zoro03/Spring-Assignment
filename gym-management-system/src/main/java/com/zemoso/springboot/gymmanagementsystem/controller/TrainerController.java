package com.zemoso.springboot.gymmanagementsystem.controller;


import com.zemoso.springboot.gymmanagementsystem.entity.Trainer;

import com.zemoso.springboot.gymmanagementsystem.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/trainer")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @GetMapping("/home")
    public String getTrainer(@RequestParam("trainerId") int trainerId, Model model){
        Trainer trainer = trainerService.findById(trainerId);
        model.addAttribute("trainer",trainer);
        return "trainer/trainer-home";
    }


}
