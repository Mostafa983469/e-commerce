package com.example.ecommerce.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String role;

    private long customerId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId" ,nullable = false,insertable = false,updatable = false)
    private Customer customer;


}
