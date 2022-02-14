package com.service.fraud.controller;

import com.service.fraud.model.RS.FraudCheckRS;
import com.service.fraud.services.FraudCheckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController
{
    private final FraudCheckService fraudCheckService;

    @GetMapping("/{customerId}")
    public FraudCheckRS isFraud(@PathVariable int customerId)
    {
        boolean isFraudCustomer = fraudCheckService.isFraudCustomer(customerId);
        log.info("fraud check request from customer " + customerId);
        return new FraudCheckRS(isFraudCustomer);
    }
}
