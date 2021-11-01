package com.example.createservice.proxy;

import com.example.createservice.dto.SalesRepDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("salesrep-service")
public interface SalesrepServiceProxy {

    @PostMapping("/salesrep")
    SalesRepDTO createSalesRep(@RequestBody SalesRepDTO salesRepDTO);
}
