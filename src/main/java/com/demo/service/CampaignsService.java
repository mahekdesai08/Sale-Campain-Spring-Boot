package com.demo.service;

import com.demo.Model.PriceHistory;
import com.demo.Model.Product;
import com.demo.Model.SaleCampaign;
import com.demo.Model.dto.CampaignsDTO;
import com.demo.Model.dto.ProductSale;
import com.demo.repository.CampaignRepo;
import com.demo.repository.PriceHistoryRepo;
import com.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@EnableScheduling
@Service
public class CampaignsService {
    @Autowired
    CampaignRepo campaignRepo;
    @Autowired
    PriceHistoryRepo priceHistoryRepo;
    @Autowired
    ProductRepo productRepo;

    public SaleCampaign addCampaign(CampaignsDTO campaignDto) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        String formattedDate = sdf.format(currentDate);

        Date current = sdf.parse(formattedDate);
        Date startDate = sdf.parse(campaignDto.getStartdate());
        Date endDate = sdf.parse(campaignDto.getEnddate());

        SaleCampaign saleCampaign = null;
        List<ProductSale> productSaleList = campaignDto.getCampaigndiscount();
        for(ProductSale productSale : productSaleList) {
            saleCampaign = new SaleCampaign();
            saleCampaign.setTitle(campaignDto.getTitle());
            saleCampaign.setStartDate(campaignDto.getStartdate());
            saleCampaign.setEndDate(campaignDto.getEnddate());
            Long productId= productSale.getProductid();
            Optional<Product> productOptional = productRepo.findById(productId);

            if (productOptional.isPresent()) {
                Product product = productOptional.get();
                saleCampaign.setDiscount(productSale.getDiscount());
                saleCampaign.setProductId(productId);
                saleCampaign.setOldPrice(product.getCurrentPrice());
                campaignRepo.save(saleCampaign);

                PriceHistory priceHistory = new PriceHistory();
                priceHistory.setPrice(product.getCurrentPrice());
                priceHistory.setProductId(product.getId());
                priceHistoryRepo.save(priceHistory);


                if (current.after(startDate) && current.before(endDate)) {
                    Product product1 = productRepo.findById(saleCampaign.getProductId()).orElse(null);
                    Product updateProduct = product1;
                    Double currentPrice = updateProduct.getCurrentPrice() - saleCampaign.getDiscount();
                    updateProduct.setCurrentPrice(currentPrice);
                    productRepo.save(updateProduct);
                }

            } else {
                System.out.println("id not found");
            }
        }
        return saleCampaign;
    }

    @Scheduled(fixedRate = 60000) // This will run the method every minute, adjust the rate as needed
// @Scheduled(cron = "0 0 23 * * ?")
    public void updateProductPrices() {
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //
        String formattedDate = sdf.format(currentDate);
        List<SaleCampaign> activeCampaigns = campaignRepo.findActiveCampaigns("2024-02-27");

        for (SaleCampaign campaign : activeCampaigns) {
            // Calculate new prices based on the campaign's old price and discount
            Double currentPrice = campaign.getOldPrice();

            // Update the product's price in the repository
            Optional<Product> productOptional = productRepo.findById(campaign.getProductId());
            if (productOptional.isPresent()) {
                Product product = productOptional.get();
                product.setCurrentPrice(currentPrice);
                productRepo.save(product);
            }
        }
    }
}
