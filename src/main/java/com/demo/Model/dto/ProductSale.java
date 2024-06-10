package com.demo.Model.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


public class ProductSale {

     Long productid;
     Double discount;

    public ProductSale( Long productid, Double discount) {

        this.productid = productid;
        this.discount = discount;
    }

    public ProductSale() {
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}

