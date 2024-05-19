package com.company.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@Entity
@Table
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Product")
public class Product {

    @Id
    //@GeneratedValue
    @Column(name="id")
    private int id;

    //@Column(name="img") // не обязательная аннотация, по умолчанию сохр все поля
    private String img;

    //@Column(name="name")
    private String name;

    //@Column(name="cost")
    private int cost;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="category_id") // задаёт имя столбца, в котором будет храниться ссылка на владеемый объект
    private Category category; //  в ячейках этого столбца содержится значения первичных ключей владеемого объекта и такого же типа как эти значения

    @OneToMany(mappedBy = "product")
    private List<OrderedProduct> orderedProducts;

    /* @Column(name="quantity")
    private int quantity;*/
    //private int date;




    public Product(){

    }

    public Product(int id, String img, String name, int cost) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.cost = cost;

    }

    //private int category;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    /*public void setCategory(int category) {
        this.category = category;
    }*/

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
