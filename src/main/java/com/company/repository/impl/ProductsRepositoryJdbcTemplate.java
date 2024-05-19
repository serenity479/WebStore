package com.company.repository.impl;


import com.company.dto.Product;
import com.company.mappers.ProductMapper;
import com.company.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;


@Repository
@CacheConfig(cacheNames = "product")
public class ProductsRepositoryJdbcTemplate implements ProductsRepository{


    @Autowired
    private JdbcTemplate jdbcTemplate;


    private Logger logger = LoggerFactory.getLogger(ProductsRepositoryJdbcTemplate.class);


    public void addProduct(Product product){
        String sql = "INSERT INTO product (id, img, name, cost, category_id) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, product.getId(), product.getImg(), product.getName(), product.getCost(),  product.getCategory().getId());
    }

    public void delete(Integer id){
        String sql = "DELETE FROM product WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void update(Integer id, Product updateproduct) {
        String sql = "UPDATE product SET img = ?, name = ?, cost = ?, category_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, updateproduct.getImg(), updateproduct.getName(), updateproduct.getCost(), updateproduct.getCategory().getId(), id);
    }

    @Cacheable("product")
    public Product findById(Integer id){
        logger.info("findById() executed");
        String sql = "SELECT * FROM product WHERE id = ?";
        Product product = (Product) jdbcTemplate.queryForObject(sql, new Object[]{id}, new ProductMapper());
        return product;
    }

    @Cacheable("products")
    public List<Product> findByName(String name){
        logger.info("findByName() executed");
        String sql = "SELECT * FROM product WHERE name = ?";
        List<Product> products = (List<Product>)jdbcTemplate.query(sql, new Object[]{name}, new ProductMapper());
        return products;
    }

    @Cacheable("product")
    public List<Product> findByCost(Integer cost){
        logger.info("findByCost() executed");
        String sql = "SELECT * FROM product WHERE cost = ?";
        List<Product> products = (List<Product>)jdbcTemplate.query(sql, new Object[]{cost}, new ProductMapper());
        return products;
    }


    @CacheEvict(allEntries = true)
    public void clearCache(){}





}
