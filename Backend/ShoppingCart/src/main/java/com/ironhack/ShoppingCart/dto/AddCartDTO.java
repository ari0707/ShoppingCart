package com.ironhack.ShoppingCart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCartDTO {

    private Integer id;

    @NotNull
    private Integer productId;

    @NotNull
    private Integer quantity;

}
