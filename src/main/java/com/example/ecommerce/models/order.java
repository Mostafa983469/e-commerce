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
@Table(name = "Orders")
public class order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long productId ;

    private int productQuantity ;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productId",insertable = false,nullable = false,updatable = false )
    private product product;


    private long customerId ;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId",nullable = false,insertable = false,updatable = false)
    private Customer customer;

}
