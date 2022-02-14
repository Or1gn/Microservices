package com.service.customer.model.repository;

import com.service.customer.model.enums.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer>
{

}
