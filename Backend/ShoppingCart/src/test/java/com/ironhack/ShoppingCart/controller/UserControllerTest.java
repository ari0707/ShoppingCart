package com.ironhack.ShoppingCart.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ironhack.ShoppingCart.dto.ProductDTO;
import com.ironhack.ShoppingCart.dto.SignInDTO;
import com.ironhack.ShoppingCart.dto.SignInResponseDTO;
import com.ironhack.ShoppingCart.dto.UserSignUpDTO;
import com.ironhack.ShoppingCart.model.Category;
import com.ironhack.ShoppingCart.repository.CategoryRepository;
import com.ironhack.ShoppingCart.repository.ProductRepository;
import com.ironhack.ShoppingCart.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class UserControllerTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Test
    void signUpTest() throws Exception {
        UserSignUpDTO userSignUpDTO = new UserSignUpDTO("ari", "ro","http", "wewewe");
        String body = objectMapper.writeValueAsString(userSignUpDTO);

        mockMvc.perform(post("/user/signup").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    void signInResponseDTO() throws Exception {
        SignInDTO signInDTO = new SignInDTO("http", "wewewe");
        String body = objectMapper.writeValueAsString(signInDTO);

        mockMvc.perform(post("/user/signin").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
    }
}