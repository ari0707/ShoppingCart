package com.ironhack.ShoppingCart.service;

import com.ironhack.ShoppingCart.dto.ResponseDTO;
import com.ironhack.ShoppingCart.dto.SignInDTO;
import com.ironhack.ShoppingCart.dto.SignInResponseDTO;
import com.ironhack.ShoppingCart.dto.UserSignUpDTO;
import com.ironhack.ShoppingCart.model.Token;
import com.ironhack.ShoppingCart.model.User;
import com.ironhack.ShoppingCart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenService tokenService;

    public ResponseDTO signUp(UserSignUpDTO userSignUpDTO) {

        if (Objects.nonNull(userRepository.findByEmail(userSignUpDTO.getEmail()))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " User not found");
        }

        String encryptedPassword = userSignUpDTO.getPassword();
        try{
            encryptedPassword = hashPassword(userSignUpDTO.getPassword());
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        User user = new User(userSignUpDTO.getFirstName(), userSignUpDTO.getLastName(), userSignUpDTO.getEmail(), encryptedPassword);
        userRepository.save(user);

        Token token = new Token(user);

        tokenService.saveConfirmationToken(token);

        ResponseDTO responseDTO = new ResponseDTO("success", "created");
        return responseDTO;

        //userRepository.findByEmail((userSignUpDTO.getEmail()));

    }
    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return hash;

    }

    public SignInResponseDTO signIn(SignInDTO signInDTO) {

        User user = userRepository.findByEmail(signInDTO.getEmail());
        if (Objects.isNull(user)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, " User is not valid");
        }
        //Hash the password
        try {
            if (!user.getPassword().equals(hashPassword(signInDTO.getPassword()))) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, " Wrong Password");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //Token token = tokenService.getToken(user);
        Token token = tokenService.getToken(user);
        if(Objects.isNull(token)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " Token is not present");
        }
        return new SignInResponseDTO("Success", token.getToken());
    }
}
