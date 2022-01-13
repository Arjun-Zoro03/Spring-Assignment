package com.zemoso.springboot.gymmanagementsystem.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trainer")
@Getter @Setter
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int trainerId;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phone_number")
    private String phoneNumber;

    public Trainer() {

    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + trainerId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", number='" + phoneNumber + '\'' +
                '}';
    }

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "trainer",cascade = CascadeType.ALL)
    private User user;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "customer_trainer",
            joinColumns = @JoinColumn(name = "trainer_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private List<Customer> customers;

    public void addCustomer(Customer customer){
        if (customers == null)
            customers = new ArrayList<>();
        customers.add(customer);
    }

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REMOVE,CascadeType.REFRESH})
    @JoinColumn(name = "trainer_id")
    private List<Workout> workouts;

    public void addWorkout(Workout workout){
        if (workouts == null)
            workouts = new ArrayList<>();
        workouts.add(workout);
    }
}
