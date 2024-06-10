package com.demo.controller;

import com.demo.Model.SaleCampaign;
import com.demo.Model.dto.CampaignsDTO;
import com.demo.service.CampaignsService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("CreateCampaign")
public class CampaignsController {
    @Autowired
    CampaignsService campaignsService;
    @PostMapping("/addCampaign")
    public SaleCampaign addCampaign(@RequestBody CampaignsDTO campaignDto) throws ParseException {
        return campaignsService.addCampaign(campaignDto);
    }
    @PostMapping("/update")
    public void update() throws ParseException{
       campaignsService.updateProductPrices();
    }


}
