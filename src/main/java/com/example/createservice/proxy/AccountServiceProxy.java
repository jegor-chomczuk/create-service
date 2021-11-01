package com.example.createservice.proxy;

import com.example.createservice.dto.AccountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("account-service")
public interface AccountServiceProxy {

    @PostMapping("/accounts")
    AccountDTO create(@RequestBody AccountDTO accountDTO);
}
