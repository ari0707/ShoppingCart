package com.ironhack.ShoppingCart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSignUpDTO {

    private String firstName;

    private String lastName;

    private String email;

    private String password;


}
