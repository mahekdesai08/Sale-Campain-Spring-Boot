package com.demo.service;

import com.demo.Model.PriceHistory;
import com.demo.repository.PriceHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceHistoryService {
    @Autowired
    PriceHistoryRepo priceHistoryRepo;

   public List<PriceHistory> save(List<PriceHistory> priceHistories){
       return priceHistoryRepo.saveAll(priceHistories);
   }

}
