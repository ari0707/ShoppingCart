package com.ironhack.ShoppingCart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private double price;

    @NotNull
    private String imageURL;

    @NotNull
    private String description;

    @NotNull
    private Integer categoryId;
}
