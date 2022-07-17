package com.example.shoppingapp.Repository;

import com.example.shoppingapp.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

    Optional<Products> findById(Long id);

//    Products findById(int id);




}
