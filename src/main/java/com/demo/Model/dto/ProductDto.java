package com.demo.Model.dto;

import com.demo.Model.Product;
import jdk.jfr.DataAmount;

import java.util.List;
public class ProductDto {
    private List<Product> product;
    private Integer page;
    private Integer pageSize;
    private Integer totalPage;
    public List<Product> getProduct() {
        return product;
    }
    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public ProductDto() {
    }

    public ProductDto(List<Product> product, Integer page, Integer pageSize, Integer totalPage) {
        this.product = product;
        this.page = page;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
    }


    @Override
    public String toString() {
        return "ProductDto{" +
                "product=" + product +
                ", page=" + page +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                '}';
    }
}
