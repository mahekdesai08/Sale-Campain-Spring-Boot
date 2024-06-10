package com.demo.repository;


import com.demo.Model.SaleCampaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public interface CampaignRepo extends JpaRepository<SaleCampaign,Long> {

    @Query(value = "select * from sale_campaign where end_date<=:currentDate ",nativeQuery = true)
    List<SaleCampaign> findActiveCampaigns(String currentDate);
}
//cureent date : 27 //end date : 26