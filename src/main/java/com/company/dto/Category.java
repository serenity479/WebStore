package com.company.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category") // указывает какое поле в объекте владельце соответствует владеемому объекту
    private List<Product> products; // для 1ой категории один список, для 2ой другой





    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
