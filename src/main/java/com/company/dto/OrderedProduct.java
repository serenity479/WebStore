package com.company.dto;

import javax.persistence.*;

@Entity
@Table(name="ordered_product")
public class OrderedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id") // множество заказов может быть для одного продукта
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id") // можество продуктов может быть для одного заказа
    private Product product;

    public int getId() {
        return id;
    }

    public OrderedProduct(){

    }

    public OrderedProduct(Order order, Product product) {
        this.order = order;
        this.product = product;
    }
}
