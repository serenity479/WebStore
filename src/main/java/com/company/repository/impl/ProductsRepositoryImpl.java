package com.company.repository.impl;


import com.company.dto.Category;
import com.company.dto.Product;
import com.company.repository.ProductsRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
@Transactional
public class ProductsRepositoryImpl /*implements ProductsRepository*/ {

    private String images[] = {"img/no-image-found.jpg","img/no-image-found.jpg", "img/no-image-found.jpg", "img/no-image-found.jpg", "img/no-image-found.jpg", "img/no-image-found.jpg"};
    private int costs[] = {1243, 676, 9097, 2432, 11434, 8999, 7152};
    private Random random = new Random();
    private final int NUMBER_OF_PRODUCTS = 20;
    private final int NUMBER_OF_SECTIONS = 4;



    @PersistenceContext
    private EntityManager entityManager;

    public void addProduct(Product product){
        entityManager.persist(product);
    }

    public void delete(Product product) {
        if (entityManager.contains(product)) {
            entityManager.remove(product);
        }
    }








   public void generateProducts() {
        int counterProd=0;

        for(int i=0; i<NUMBER_OF_SECTIONS; i++) {

            //ArrayList<Product> products = new ArrayList<>();
            Category category = new Category(i, "Категория " + i);
            category.setName("name"+i);

            for (int j = 0; j < NUMBER_OF_PRODUCTS; j++, counterProd++ ){
                Product product = new Product();
                product.setName("Product" + counterProd); //names[random.nextInt(names.length)]
                product.setImg(images[random.nextInt(images.length)]);
                product.setCost(costs[random.nextInt(costs.length)]);
                product.setId(counterProd);
                //product.setCategory(category);

                //products.add(product);
                category.getProducts().add(product); // добавили продукт в список внутри категории
                entityManager.persist(product); // в таблицу продуктов   // РАБОТАЮТ ТОЛЬКО ПРОДУКТЫ
            }
            //productSections.add(products);
           entityManager.persist(category); // в таблицу категорий
        }


    }



}
