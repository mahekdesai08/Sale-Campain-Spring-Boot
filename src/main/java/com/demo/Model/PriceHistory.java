package com.demo.Model;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity

public class PriceHistory {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    Double price;
    Long productId;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public PriceHistory(long id, Double price, Long productId) {
        this.id = id;
        this.price = price;
        this.productId = productId;

    }

    public PriceHistory() {
    }

    @Override
    public String toString() {
        return "PriceHistory{" +
                "id=" + id +
                ", price=" + price +
                ", productId=" + productId +
                '}';
    }
}
