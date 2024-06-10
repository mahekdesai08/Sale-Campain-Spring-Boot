package com.demo.controller;

import com.demo.Model.PriceHistory;
import com.demo.service.PriceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/price")
public class PriceHistoryController {
    @Autowired
    PriceHistoryService priceHistoryService;

    @PostMapping("/add")
    public List<PriceHistory> saveAll(@RequestBody List<PriceHistory> priceHistories){
        return priceHistoryService.save(priceHistories);
    }
}
