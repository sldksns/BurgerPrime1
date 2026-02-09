package org.example.burgerprime.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_products")
@Data
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String name;

    private Integer quantity;

    private Double price;

    public OrderProduct() {}

    public OrderProduct(Order order, Product product, Integer quantity) {
        this.name = product.getName();
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = product.getPrice();
    }
}
