package com.demo.service;

import com.demo.Model.PriceHistory;
import com.demo.Model.Product;
import com.demo.Model.SaleCampaign;
import com.demo.Model.dto.ProductDto;
import com.demo.repository.ProductRepo;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productrepo;



    public List<Product> saveAll(List<Product> product){
       return productrepo.saveAll(product);
    }
    public ProductDto getListByPageNumber(Integer pageNo, Integer pageSize) {
        Page<Product> productPage = productrepo.findAll(PageRequest.of(pageNo - 1, pageSize));

        List<Product> productList = productPage.getContent();
        int totalPage = ((Page<?>) productPage).getTotalPages();

        ProductDto ans = new ProductDto();
        ans.setProduct(productList);
        ans.setPage(pageNo);
        ans.setTotalPage(totalPage);
        ans.setPageSize(pageSize);

        return ans;
    }
}

