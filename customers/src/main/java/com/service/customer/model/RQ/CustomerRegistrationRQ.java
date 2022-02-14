package com.service.customer.model.RQ;

public record CustomerRegistrationRQ(
        String firstName,
        String lastName,
        String email) {
}
