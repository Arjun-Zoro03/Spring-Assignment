package com.zemoso.springboot.gymmanagementsystem.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "authority")
@Getter @Setter
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "authority")
    private String role;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    public Authority() {

    }

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", user=" + user +
                ", role='" + role + '\'' +
                '}';
    }
}
