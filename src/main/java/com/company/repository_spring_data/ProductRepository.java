package com.company.repository_spring_data;

import com.company.dto.Category;
import com.company.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategory(Category category);

    List<Product> findByName(String name);

    List<Product> findByCost(Integer cost);

    @Override
    Optional<Product> findById(Integer integer);





}
