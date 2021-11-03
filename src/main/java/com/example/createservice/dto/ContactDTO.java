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
    private Long id;

    public ContactDTO(String name, String phoneNumber, String email, String companyName, Long salesRepId, Long accountId) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.companyName = companyName;
        this.salesRepId = salesRepId;
        this.accountId = accountId;
    }
}
