package com.ironhack.ShoppingCart.controller;

import com.ironhack.ShoppingCart.dto.ResponseDTO;
import com.ironhack.ShoppingCart.dto.SignInDTO;
import com.ironhack.ShoppingCart.dto.SignInResponseDTO;
import com.ironhack.ShoppingCart.dto.UserSignUpDTO;
import com.ironhack.ShoppingCart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDTO signUp(@RequestBody UserSignUpDTO userSignUpDTO){

        return userService.signUp(userSignUpDTO);
    }

    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.CREATED)
    public SignInResponseDTO signInResponseDTO(@RequestBody SignInDTO signInDTO){
        return  userService.signIn(signInDTO);
    }

}
