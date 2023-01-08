package com.ironhack.ShoppingCart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(name = "category_name")
    private String categoryName;

    @NotBlank
    @Column(name = "description")
    private String description;

    @NotBlank
    @Column(name = "image_url")
    private String imageUrl;


}
