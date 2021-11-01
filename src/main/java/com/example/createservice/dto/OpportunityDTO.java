package com.example.createservice.dto;

import com.example.createservice.enums.Status;
import com.example.createservice.enums.Truck;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OpportunityDTO {
    private Status status;
    private Truck product;
    private Integer quantity;
    private Long decisionMaker;
    private Long accountId;
    private Long salesRepId;
}
