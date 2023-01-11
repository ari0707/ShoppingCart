package com.ironhack.ShoppingCart.service;

import com.ironhack.ShoppingCart.model.Token;
import com.ironhack.ShoppingCart.model.User;
import com.ironhack.ShoppingCart.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class TokenService {

    @Autowired
    TokenRepository tokenRepository;

    public void saveConfirmationToken(Token token) {
        tokenRepository.save(token);
    }

    public User getUser(String token){
        Token authenticationToken = tokenRepository.findByToken(token);
        if(Objects.isNull(authenticationToken)){
            return null;
        }
        return authenticationToken.getUser();
    }
    public Token getToken(User user) {

        return tokenRepository.findByUser(user);
    }

    public void authenticate(String token){
        if(Objects.isNull(token)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " Token not found");
        }
        if (Objects.isNull(getUser(token))){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " Token not valid");
        }
    }


}
