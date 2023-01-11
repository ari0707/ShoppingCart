package com.ironhack.ShoppingCart.dto;

import com.ironhack.ShoppingCart.model.Cart;
import com.ironhack.ShoppingCart.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO {

    private Integer id;
    private Integer quantity;
    private Product product;

    public CartItemDTO(Cart cart){
        this.id = cart.getId();
        this.quantity = cart.getQuantity();
        this.setProduct(cart.getProduct());
    }
}
