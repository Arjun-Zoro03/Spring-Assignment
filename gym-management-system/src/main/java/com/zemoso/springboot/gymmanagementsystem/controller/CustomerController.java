package com.zemoso.springboot.gymmanagementsystem.controller;

import com.zemoso.springboot.gymmanagementsystem.converter.CustomerConverter;
import com.zemoso.springboot.gymmanagementsystem.dto.CustomerDTO;
import com.zemoso.springboot.gymmanagementsystem.entity.Customer;
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
@RequestMapping("/customers")
public class CustomerController {

    private CustomerConverter customerConverter = new CustomerConverter();

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TrainerService trainerService;

    private int trainerId;

    @GetMapping("/home")
    public String getCustomer(@RequestParam("customerId") int customerId, Model model){

        CustomerDTO customer = customerConverter.entityToDto(customerService.findById(customerId));
        model.addAttribute("customer",customer);

        return "customer/customer-home";
    }

    @GetMapping("/list")
    public String listCustomers(@RequestParam("trainerId") int trainerId, Model theModel) {

        this.trainerId = trainerId;
        List<CustomerDTO> customers = customerConverter.entityToDto(customerService.findAll());
        theModel.addAttribute("customers", customers);
        theModel.addAttribute("trainerId", trainerId);

        return "customer/customers-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(@RequestParam("trainerId") int trainerId, Model theModel) {

        CustomerDTO customer = customerConverter.entityToDto(new Customer());
        theModel.addAttribute("customer", customer);
        theModel.addAttribute("trainerId", trainerId);

        return "customer/customer-form";
    }

    @PostMapping("/save")
    public String saveCustomer(@Valid @ModelAttribute("customer") CustomerDTO customer, BindingResult bindingResult
                              ){

        if(bindingResult.hasErrors())
            return "customer/customer-form";
        customerService.saveTrainerCustomer(trainerService.findById(trainerId),
                customerConverter.dtoToEntity(customer));

        return "redirect:/customers/list?trainerId="+trainerId;
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("customerId") int customerId,
                                    Model theModel) {

        theModel.addAttribute("trainerId", trainerId);
        CustomerDTO customer = customerConverter.entityToDto(customerService.findById(customerId));
        theModel.addAttribute("customer", customer);

        return "customer/customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int customerId){
        customerService.deleteById(customerId);
        return "redirect:/customers/list?trainerId="+trainerId;
    }

}
