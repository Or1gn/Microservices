package com.service.fraud.services;

import com.service.fraud.model.enums.FraudCheckHistory;
import com.service.fraud.model.repository.FraudCheckHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService
{
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudCustomer(int customerId)
    {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraud(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
