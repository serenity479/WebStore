package com.company.dto;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="shop_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "customer_id") // у одного usera один order
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderedProduct> orderedProducts;

    public void setUser(User user) {
        this.user = user;
    }
}
