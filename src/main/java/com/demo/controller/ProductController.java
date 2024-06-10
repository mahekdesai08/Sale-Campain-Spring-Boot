package com.demo.controller;

import com.demo.Model.Product;
import com.demo.Model.dto.ProductDto;
import com.demo.repository.ProductRepo;
import com.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public List<Product> addProduct(@RequestBody List<Product> product){
        return productService.saveAll(product);
    }

    @GetMapping("/get")
    public ProductDto getListByPageNumber(@RequestParam int pageNo,int pageSize){
        return productService.getListByPageNumber(pageNo,pageSize);
    }


}






