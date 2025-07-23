package com.n1jel.market.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "user_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user_generator", sequenceName = "users_seq")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany
    private List<Car> userCars;
}
