package com.ironhack.ShoppingCart.service;

import com.ironhack.ShoppingCart.dto.ProductDTO;
import com.ironhack.ShoppingCart.model.Category;
import com.ironhack.ShoppingCart.model.Product;
import com.ironhack.ShoppingCart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void createProduct(ProductDTO productDTO, Category category) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setImageURL(productDTO.getImageURL());
        product.setDescription(productDTO.getDescription());
        product.setCategory(category);
        productRepository.save(product);
    }

    public ProductDTO getProductDto(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setImageURL(product.getImageURL());
        productDTO.setDescription(product.getDescription());
        productDTO.setCategoryId(product.getCategory().getId());
        return productDTO;
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : productList) {
            productDTOList.add(getProductDto(product));
        }
        return productDTOList;
    }
}
