package com.ironhack.ShoppingCart.repository;

import com.ironhack.ShoppingCart.model.Cart;
import com.ironhack.ShoppingCart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findAllByUserOrderByCreatedDate(User user);
}
