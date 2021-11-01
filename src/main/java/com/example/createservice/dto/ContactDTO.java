package com.example.createservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;
    private Long salesRepId;
    private Long accountId;
}
