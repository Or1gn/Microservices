package com.service.customer.service;

import com.service.customer.model.RQ.CustomerRegistrationRQ;
import com.service.customer.model.RS.*;
import com.service.customer.model.enums.Customer;
import com.service.customer.model.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomService
{
    private final CustomerRepository customerRepository;

    private final RestTemplate restTemplate;

    public void registerCustom(CustomerRegistrationRQ request)
    {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastname(request.lastName())
                .email(request.email())
                .build();

        customerRepository.saveAndFlush(customer);

        FraudCheckRS fraudCheckRS = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckRS.class,
                customer.getId()
        );

        if (fraudCheckRS.isFraud())
        {
            throw new IllegalStateException("fraud");
        }
    }
}
