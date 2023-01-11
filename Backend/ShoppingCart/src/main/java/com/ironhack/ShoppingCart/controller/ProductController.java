package com.ironhack.ShoppingCart.controller;

import com.ironhack.ShoppingCart.dto.ProductDTO;
import com.ironhack.ShoppingCart.model.Category;
import com.ironhack.ShoppingCart.model.Product;
import com.ironhack.ShoppingCart.repository.CategoryRepository;
import com.ironhack.ShoppingCart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createProduct(@RequestBody ProductDTO productDTO){
        Optional<Category> optionalCategory = categoryRepository.findById(productDTO.getCategoryId());
        if(!optionalCategory.isPresent()){
            return (HttpStatus.BAD_REQUEST + " Category does not exists");
        }
        productService.createProduct(productDTO, optionalCategory.get());
        return (HttpStatus.CREATED + " Product has been added");

    }

    @GetMapping("/list")
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }
}
