package com.ironhack.ShoppingCart.controller;

import com.ironhack.ShoppingCart.dto.AddCartDTO;
import com.ironhack.ShoppingCart.dto.CartDTO;
import com.ironhack.ShoppingCart.dto.SignInResponseDTO;
import com.ironhack.ShoppingCart.model.Token;
import com.ironhack.ShoppingCart.model.User;
import com.ironhack.ShoppingCart.service.CartService;
import com.ironhack.ShoppingCart.service.ProductService;
import com.ironhack.ShoppingCart.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String addToCart(@RequestBody AddCartDTO addCartDTO,
                            @RequestParam("token") String token){

        //Authentication token
        tokenService.authenticate(token);

        //Find the User
        User user = tokenService.getUser(token);

        cartService.addToCart(addCartDTO, user);
        return (HttpStatus.CREATED + " Added to cart");

    }


    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public CartDTO getCartItems(@RequestParam("token") String token){

        //Authentication token
        tokenService.authenticate(token);

        //Find the User
        User user = tokenService.getUser(token);

        CartDTO cartDTO = cartService.listCartItems(user);
        return cartDTO;
    }

    @DeleteMapping("/delete/{cartItemId}")
    public String deleteCartItem(@PathVariable("cartItemId") Integer itemId,
                                 @RequestParam("token") String token){
        //Authentication token
        tokenService.authenticate(token);

        //Find the User
        User user = tokenService.getUser(token);

        cartService.deleteCartItem(itemId, user);
        return (HttpStatus.OK + " Item has been removed");

    }



}
