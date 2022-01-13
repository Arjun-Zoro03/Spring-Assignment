package com.zemoso.springboot.gymmanagementsystem.controller;

import com.zemoso.springboot.gymmanagementsystem.entity.Customer;
import com.zemoso.springboot.gymmanagementsystem.entity.Trainer;
import com.zemoso.springboot.gymmanagementsystem.service.CustomerService;
import com.zemoso.springboot.gymmanagementsystem.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TrainerService trainerService;

    private int trainerId;

    @GetMapping("/home")
    public String getCustomer(@RequestParam("id") int id, Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer",customer);
        return "customer/customer-home";
    }


    @GetMapping("/list")
    public String listCustomers(Model theModel, @RequestParam("trainerId") int trainerId) {

        this.trainerId = trainerId;
        List<Customer> customers = customerService.findAll();
        theModel.addAttribute("customers", customers);
        theModel.addAttribute("trainerId", trainerId);

        return "customer/customers-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        Customer customer = new Customer();
        theModel.addAttribute("customer", customer);
        theModel.addAttribute("trainerId", trainerId);

        return "customer/customer-form";
    }

    @PostMapping("/save")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult
                              ){

        if(bindingResult.hasErrors())
            return "customer/customer-form";
        Trainer trainer = trainerService.findById(trainerId);
        customerService.saveTrainerCustomer(trainer,customer);

        return "redirect:/customer/list?trainerId="+trainerId;
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("customerId") int customerId,
                                    Model theModel) {

        Customer customer = customerService.findById(customerId);
        theModel.addAttribute("customer", customer);

        return "customer/customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int customerId){
        customerService.deleteById(customerId);
        return "redirect:/customer/list?trainerId="+trainerId;
    }

}
