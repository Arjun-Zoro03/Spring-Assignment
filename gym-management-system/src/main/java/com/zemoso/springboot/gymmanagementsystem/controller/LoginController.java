package com.zemoso.springboot.gymmanagementsystem.controller;

import com.zemoso.springboot.gymmanagementsystem.entity.Users;
import com.zemoso.springboot.gymmanagementsystem.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/")
    public String redirect(){
        return "redirect:/show-login-page";
    }

    @GetMapping("/show-login-page")
    public String showLoginPage(){
        return "login";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "access-denied";
    }

    @GetMapping("/home")
    public String showHomePage(Model model, Authentication authentication){
        String name = authentication.getName();
        Users users = usersService.findById(name);
        int id;
        if (users.getCustomer() == null) {
            id = users.getTrainer().getTrainerId();
        }
        else {
            id = users.getCustomer().getCustomerId();
        }
        model.addAttribute("id",id);
        return "home";
    }
}
