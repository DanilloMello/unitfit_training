package com.unitfit.training.customerservice.internal.infrastructure.gateways;

import com.unitfit.training.customerservice.internal.core.domains.Customer;
import com.unitfit.training.customerservice.internal.infrastructure.utils.dtos.CustomerCreateResponse;

import java.util.Optional;
import java.util.UUID;

public interface CustomerDatabaseGateway {
    void save(Customer customer);
    Optional<CustomerCreateResponse> findById(UUID id);
}
