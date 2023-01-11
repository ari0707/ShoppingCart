package com.ironhack.ShoppingCart.repository;

import com.ironhack.ShoppingCart.model.Token;
import com.ironhack.ShoppingCart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {
    Token findByUser(User user);

    Token findByToken(String user);
}
