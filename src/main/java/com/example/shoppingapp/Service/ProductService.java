package com.example.shoppingapp.Service;

import com.example.shoppingapp.Repository.ProductsRepository;
import com.example.shoppingapp.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public void addProducts(Products products){
        productsRepository.save(products);
    }

    public void deleteProducts(Long id){
        productsRepository.deleteById(id);
    }
    public Products get(Long id){
        Products products;
        products = productsRepository.findById(id).get();

        return products;
    }
    public List<Products> viewAllProducts(){
        return productsRepository.findAll();
    }



    public Optional <Products> getProductsById(Long id){

        return productsRepository.findById(id);
    }

}
