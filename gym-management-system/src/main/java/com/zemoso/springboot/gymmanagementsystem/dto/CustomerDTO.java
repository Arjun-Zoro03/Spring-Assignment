package com.zemoso.springboot.gymmanagementsystem.dto;

import com.zemoso.springboot.gymmanagementsystem.entity.Trainer;
import com.zemoso.springboot.gymmanagementsystem.entity.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;


@Getter
@Setter
public class CustomerDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @NotBlank(message = "Customer name is required")
    private String name;

    @Min(value = 14, message = "Age must be at least 14")
    private int age;

    private String gender;

    @Pattern(regexp = "^[6-9]\\d{9}$",message ="Enter a 10-digit Phone Number")
    private String phoneNumber;

    @NotBlank(message = "This is a required field")
    private String startDate;

    @NotBlank(message = "This is a required field")
    private String endDate;

    private Users user;

    private List<Trainer> trainers;
}
