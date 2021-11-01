package com.example.createservice;

import com.example.createservice.dto.*;
import com.example.createservice.proxy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/create")
public class CreateController {

    @Autowired
    ContactServiceProxy contactServiceProxy;

    @Autowired
    OpportunityServiceProxy opportunityServiceProxy;

    @Autowired
    LeadServiceProxy leadServiceProxy;

    @Autowired
    AccountServiceProxy accountServiceProxy;

    @Autowired
    SalesrepServiceProxy salesrepServiceProxy;

    //    Test endpoint: localhost:8700/create/contact

    //    Test request:
    //    {
    //        "name":"Contact Name",
    //            "phoneNumber":"123456789",
    //            "email":"email@domain.com",
    //            "companyName":"Company Name",
    //            "salesRepId":"3",
    //            "accountId":"3"
    //    }
    @PostMapping("/contact")
    @ResponseStatus(HttpStatus.CREATED)
    public void createContact(@RequestBody ContactDTO contactDTO){
        contactServiceProxy.store(contactDTO);
    }
    //    Test endpoint: localhost:8700/create/opportunity
    //
    //    Test request:
    //        {
    //            "id": 4,
    //                "status": "OPEN",
    //                "product": "FLATBED",
    //                "quantity": 10,
    //                "decisionMaker": 1,
    //                "accountId": null,
    //                "salesRepId": 1
    //        }
    @PostMapping("/opportunity")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOpportunity(@RequestBody OpportunityDTO opportunityDTO){
        opportunityServiceProxy.createOpp(opportunityDTO);
    }

    //    Test endpoint: localhost:8700/create/lead
    //
    //    Test request:
    //    {
    //        "name":"Lead Name",
    //            "phoneNumber":"123456789",
    //            "email":"email@domain.com",
    //            "companyName":"Company Name",
    //            "salesRep":"2"
    //    }
    @PostMapping("/lead")
    @ResponseStatus(HttpStatus.CREATED)
    public void createLead(@RequestBody NewLeadDTO newLead){
        leadServiceProxy.createLead(newLead);
    }

    //    Test endpoint: localhost:8700/create/account
    //
    //    Test request:
    //    {
    //        "id":"2",
    //            "industry":"ECOMMERCE",
    //            "employeeCount":21,
    //            "city":"Poznań",
    //            "country":"Poland"
    //    }
    @PostMapping("/account")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@RequestBody AccountDTO accountDTO){
        accountServiceProxy.create(accountDTO);
    }

    //    Test endpoint: localhost:8700/create/salesrep
    //
    //    Test request:
    //    {
    //        "id":"3",
    //            "repName":"SalesRep Name"
    //    }
    @PostMapping("/salesrep")
    @ResponseStatus(HttpStatus.CREATED)
    public void createSalesrep(@RequestBody SalesRepDTO salesRepDTO){
        salesrepServiceProxy.createSalesRep(salesRepDTO);
    }

    //    Test endpoint: localhost:8700/create/contact-opportunity
    //
    //    Test request:
    //    {
    //        "name":"Contact Name",
    //            "phoneNumber":"123456789",
    //            "email":"email@domain.com",
    //            "companyName":"Company Name",
    //            "salesRepId":"3",
    //            "id": 4,
    //            "status": "OPEN",
    //            "product": "FLATBED",
    //            "quantity": 10,
    //            "decisionMaker": 1,
    //            "accountId": null
    //    }
    @PostMapping("/contact-opportunity")
    @ResponseStatus(HttpStatus.CREATED)
    public void createContact(@RequestBody ContactAndOpportunityDTO contactAndOpportunityDTO){
        ContactDTO contactDTO = new ContactDTO(
                contactAndOpportunityDTO.getName(),
                contactAndOpportunityDTO.getPhoneNumber(),
                contactAndOpportunityDTO.getEmail(),
                contactAndOpportunityDTO.getCompanyName(),
                contactAndOpportunityDTO.getSalesRepId(),
                contactAndOpportunityDTO.getAccountId()
        );

        contactServiceProxy.store(contactDTO);

        OpportunityDTO opportunityDTO = new OpportunityDTO(
                contactAndOpportunityDTO.getStatus(),
                contactAndOpportunityDTO.getProduct(),
                contactAndOpportunityDTO.getQuantity(),
                contactAndOpportunityDTO.getDecisionMaker(),
                contactAndOpportunityDTO.getAccountId(),
                contactAndOpportunityDTO.getSalesRepId()
        );

        opportunityServiceProxy.createOpp(opportunityDTO);
    }

//    Test endpoint: localhost:8700/create/contact-opportunity-account
//
//    Test request:
//    {
//        "name":"Contact Name",
//            "phoneNumber":"123456789",
//            "email":"email@domain.com",
//            "companyName":"Company Name",
//            "salesRepId":"3",
//            "status": "OPEN",
//            "product": "FLATBED",
//            "quantity": 10,
//            "decisionMaker": 1,
//            "accountId": null,
//            "id":"5",
//            "industry":"ECOMMERCE",
//            "employeeCount":21,
//            "city":"Poznań",
//            "country":"Poland"
//    }
    @PostMapping("/contact-opportunity-account")
    @ResponseStatus(HttpStatus.CREATED)
    public void createContact(@RequestBody ContactAndOppotrtunityAndAccountDTO contactAndOppotrtunityAndAccountDTO){
        ContactDTO contactDTO = new ContactDTO(
                contactAndOppotrtunityAndAccountDTO.getName(),
                contactAndOppotrtunityAndAccountDTO.getPhoneNumber(),
                contactAndOppotrtunityAndAccountDTO.getEmail(),
                contactAndOppotrtunityAndAccountDTO.getCompanyName(),
                contactAndOppotrtunityAndAccountDTO.getSalesRepId(),
                contactAndOppotrtunityAndAccountDTO.getAccountId()
        );

        contactServiceProxy.store(contactDTO);

        OpportunityDTO opportunityDTO = new OpportunityDTO(
                contactAndOppotrtunityAndAccountDTO.getStatus(),
                contactAndOppotrtunityAndAccountDTO.getProduct(),
                contactAndOppotrtunityAndAccountDTO.getQuantity(),
                contactAndOppotrtunityAndAccountDTO.getDecisionMaker(),
                contactAndOppotrtunityAndAccountDTO.getAccountId(),
                contactAndOppotrtunityAndAccountDTO.getSalesRepId()
        );

        opportunityServiceProxy.createOpp(opportunityDTO);

        AccountDTO accountDTO = new AccountDTO(
                contactAndOppotrtunityAndAccountDTO.getId(),
                contactAndOppotrtunityAndAccountDTO.getIndustry(),
                contactAndOppotrtunityAndAccountDTO.getEmployeeCount(),
                contactAndOppotrtunityAndAccountDTO.getCity(),
                contactAndOppotrtunityAndAccountDTO.getCountry()
        );

        accountServiceProxy.create(accountDTO);
    }
}
