package com.service.customer.controller;

import com.service.customer.model.RQ.CustomerRegistrationRQ;
import com.service.customer.service.CustomService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerController
{
    private final CustomService customService;

    @PostMapping("/")
    public void registerCustomer(@RequestBody CustomerRegistrationRQ customerRegistrationRQ)
    {
        log.info("new customer registration " + customerRegistrationRQ);
        customService.registerCustom(customerRegistrationRQ);
    }
}
