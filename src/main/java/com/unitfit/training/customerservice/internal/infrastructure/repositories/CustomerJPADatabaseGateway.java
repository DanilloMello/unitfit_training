package com.unitfit.training.customerservice.internal.infrastructure.repositories;

import com.unitfit.training.customerservice.internal.core.domains.Customer;
import com.unitfit.training.customerservice.internal.infrastructure.gateways.CustomerDatabaseGateway;
import com.unitfit.training.customerservice.internal.infrastructure.utils.dtos.CustomerCreateResponse;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.UUID;

import static java.util.Optional.of;

@RequiredArgsConstructor
public class CustomerJPADatabaseGateway implements CustomerDatabaseGateway {

    private final CustomerJPARepository customerJPARepository;

    @Override
    public void save(Customer customer) {
        customerJPARepository.save(customer);
    }

    @Override
    public Optional<CustomerCreateResponse> findById(UUID id) {
        return of(customerJPARepository.findCustomerById(id));
    }

}