package com.example.Product.Manager.service;


import com.example.Product.Manager.dto.ProductDto;
import com.example.Product.Manager.entity.Product;
import com.example.Product.Manager.repository.CategoryRepository;
import com.example.Product.Manager.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public Product create (ProductDto dto){
        Product product = Product.builder()
                .name(dto.getName())
                .amount(dto.getAmount())
                .category(categoryService.readById(dto.getCategoryId()))
                .build();
        return productRepository.save(product);
    }

    public List<Product> readAll(){
        return productRepository.findAll();
    }

    public List<Product> readByCategoryID(Long id){
        return productRepository.findByCategoryId(id);
    }

    public Product update(Product product){
        return productRepository.save(product);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}
