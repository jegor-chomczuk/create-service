package com.example.createservice.dto;

import com.example.createservice.enums.Status;
import com.example.createservice.enums.Truck;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactAndOpportunityDTO {
    // Contact dataDTO
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;

    // OpportunityDTO data
    private Status status;
    private Truck product;
    private Integer quantity;
    private Long decisionMaker;
    private Long accountId;

    // Common data
    private Long salesRepId;
}
