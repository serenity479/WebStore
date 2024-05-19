package com.company.repository.impl;

import com.company.dto.Category;
import com.company.repository.CategoriesRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class CategoriesRepositoryImpl implements CategoriesRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public void addCategory(Category category){
        entityManager.persist(category);
    }
}
