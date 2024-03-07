package com.testproject.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;

     @Column(length =  5, nullable = false, unique = true)
     private String code;

     @Column(length =  150, nullable = false)
     private String name;

     private double price;

     @Column(length =  500, nullable = true)
     private String description;

    @ManyToOne
    private Category category;


}
