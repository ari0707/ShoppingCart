package com.ironhack.ShoppingCart.service;

import com.ironhack.ShoppingCart.dto.AddCartDTO;
import com.ironhack.ShoppingCart.dto.CartDTO;
import com.ironhack.ShoppingCart.dto.CartItemDTO;
import com.ironhack.ShoppingCart.model.Cart;
import com.ironhack.ShoppingCart.model.Product;
import com.ironhack.ShoppingCart.model.User;
import com.ironhack.ShoppingCart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    ProductService productService;

    @Autowired
    CartRepository cartRepository;
    public void addToCart(AddCartDTO addCartDTO, User user) {

        //Validate id product
        Product product = productService.findById(addCartDTO.getProductId());

        //Save the cart
        Cart cart = new Cart();
        cart.setProduct(product);
        cart.setUser(user);
        cart.setId(addCartDTO.getQuantity());
        cart.setCreatedDate(new Date());
        cartRepository.save(cart);
    }

    public CartDTO listCartItems(User user) {
        List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDate(user);
        List<CartItemDTO> cartItems = new ArrayList<>();

        double totalCost = 0;
        for (Cart cart: cartList){
            CartItemDTO cartItemDTO = new CartItemDTO(cart);
            totalCost += cartItemDTO.getQuantity() * cart.getProduct().getPrice();
            cartItems.add(cartItemDTO);
        }
        CartDTO cartDTO = new CartDTO();
        cartDTO.setTotalCost(totalCost);
        cartDTO.setCartItems(cartItems);
        return cartDTO;

    }

    public void deleteCartItem(Integer cartItemId, User user) {

        Optional<Cart> optionalCart = cartRepository.findById(cartItemId);
        if(optionalCart.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, " Cart item id is invalid" + cartItemId);
        }
        Cart cart = optionalCart.get();
        if (cart.getUser() != user){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, " Cart item does not belong to user" + cartItemId);
        }
        cartRepository.delete(cart);
    }
}
