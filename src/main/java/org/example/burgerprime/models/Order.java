package org.example.burgerprime.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.zip.DataFormatException;

@Entity
@Table(name = "orders")
@Data
@RequiredArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String address;
    private String date;
    @ManyToOne
    private Account account;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderProduct> products = new ArrayList<>();

    @PrePersist
    public void setDate() {
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd MMMM yyyy 'г.', HH:mm")
                .withLocale(new Locale("ru"));

        String formatted = LocalDateTime.now().format(formatter);
        this.date = formatted;
    }
    public int totalPrice() {
        int sum = 0;
        for (OrderProduct op : products) {
            sum += op.getProduct().getPrice() * op.getQuantity();
        }
        return sum;
    }

    public void addProduct(Product product, Integer quantity) {
        OrderProduct orderProduct = new OrderProduct(this, product, quantity);
        this.products.add(orderProduct);
    }

    // Важно: добавьте этот метод для корректной работы JPA
    public void setProducts(List<OrderProduct> products) {
        this.products.clear();
        if (products != null) {
            this.products.addAll(products);
            // Устанавливаем обратную ссылку
            for (OrderProduct op : products) {
                op.setOrder(this);
            }
        }
    }
}
