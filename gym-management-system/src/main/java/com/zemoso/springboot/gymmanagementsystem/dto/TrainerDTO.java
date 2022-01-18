package com.zemoso.springboot.gymmanagementsystem.dto;

import com.zemoso.springboot.gymmanagementsystem.entity.Customer;
import com.zemoso.springboot.gymmanagementsystem.entity.Users;
import com.zemoso.springboot.gymmanagementsystem.entity.Workout;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
public class TrainerDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trainerId;

    private String name;

    private int age;

    private String gender;

    private String phoneNumber;

    private Users user;

    private List<Customer> customers;

    private List<Workout> workouts;

}
