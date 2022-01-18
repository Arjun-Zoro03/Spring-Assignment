package com.zemoso.springboot.gymmanagementsystem.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
@Getter @Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int customerId;

    @NotBlank(message = "Customer name is required")
    @Column(name = "name")
    private String name;

    @Min(value = 14, message = "Age must be at least 14")
    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    @Pattern(regexp = "^[6-9]\\d{9}$",message ="Enter a 10-digit Phone Number")
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotBlank(message = "This is a required field")
    @Column(name = "start_date")
    private String startDate;

    @NotBlank(message = "This is a required field")
    @Column(name = "end_date")
    private String endDate;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "customer",cascade = CascadeType.ALL)
    private Users user;

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "customer_trainer",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "trainer_id")
    )
    private List<Trainer> trainers;

    public void addTrainer(Trainer trainer){
        if (trainers == null)
            trainers = new ArrayList<>();
        trainers.add(trainer);
    }
}

