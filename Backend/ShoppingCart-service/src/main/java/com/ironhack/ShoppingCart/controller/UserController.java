package com.ironhack.ShoppingCart.controller;


import com.ironhack.ShoppingCart.model.User;
import com.ironhack.ShoppingCart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllCategory(){
        return userService.getAllUser();
    }

}
