package com.example.createservice.proxy;

import com.example.createservice.dto.ContactDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("contact-service")
public interface ContactServiceProxy {

    @PostMapping("/contacts")
    ContactDTO store(@RequestBody ContactDTO contactDTO);
}

