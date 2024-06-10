package com.demo.Model.dto;

import java.util.List;

public class CampaignsDTO {
    String startdate;
    String enddate;
    String title;
    List<ProductSale> campaigndiscount;

    public CampaignsDTO(String startdate, String enddate, String title, List<ProductSale> campaigndiscount) {
        this.startdate = startdate;
        this.enddate = enddate;
        this.title = title;
        this.campaigndiscount = campaigndiscount;
    }

    public CampaignsDTO() {
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ProductSale> getCampaigndiscount() {
        return campaigndiscount;
    }

    public void setCampaigndiscount(List<ProductSale> campaigndiscount) {
        this.campaigndiscount = campaigndiscount;
    }
}
