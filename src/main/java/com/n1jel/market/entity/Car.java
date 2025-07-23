package com.n1jel.market.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "generation")
    private String generation;

    @Column(name = "price")
    BigDecimal price;

    @JoinColumn(name = "owner")
    @ManyToOne
    private User owner;
}

