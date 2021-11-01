package com.example.createservice.proxy;

import com.example.createservice.dto.OpportunityDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("opportunity-service")
public interface OpportunityServiceProxy {

    @PostMapping("/opps")
    OpportunityDTO createOpp(@RequestBody OpportunityDTO opportunityDTO);
}
