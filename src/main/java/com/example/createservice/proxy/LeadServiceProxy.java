package com.example.createservice.proxy;

import com.example.createservice.dto.LeadDTO;
import com.example.createservice.dto.NewLeadDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("lead-service")
public interface LeadServiceProxy {

    @PostMapping("/leads")
    LeadDTO createLead(@RequestBody NewLeadDTO newLead);
}
