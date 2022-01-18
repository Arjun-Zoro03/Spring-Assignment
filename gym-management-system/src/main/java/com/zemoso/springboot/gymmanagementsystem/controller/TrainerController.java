package com.zemoso.springboot.gymmanagementsystem.controller;


import com.zemoso.springboot.gymmanagementsystem.converter.TrainerConverter;
import com.zemoso.springboot.gymmanagementsystem.dto.TrainerDTO;
import com.zemoso.springboot.gymmanagementsystem.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/trainers")
public class TrainerController {

    private TrainerConverter trainerConverter = new TrainerConverter();

    @Autowired
    private TrainerService trainerService;

    @GetMapping("/home")
    public String getTrainer(@RequestParam("trainerId") int trainerId, Model model){

        TrainerDTO trainer = trainerConverter.entityToDto(trainerService.findById(trainerId));
        model.addAttribute("trainer",trainer);
        return "trainer/trainer-home";
    }


}
