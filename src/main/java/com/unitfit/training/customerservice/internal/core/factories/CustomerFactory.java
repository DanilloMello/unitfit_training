package com.unitfit.training.customerservice.internal.core.factories;

import com.unitfit.training.customerservice.internal.core.domains.Customer;
import com.unitfit.training.customerservice.internal.infrastructure.gateways.CustomerDatabaseGateway;
import com.unitfit.training.customerservice.internal.infrastructure.utils.dtos.CustomerCreateRequest;
import com.unitfit.training.customerservice.internal.infrastructure.utils.dtos.CustomerCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@RequiredArgsConstructor
@Validated
public class CustomerFactory {

    private final CustomerDatabaseGateway customerDatabase;
    
    public HttpStatus create(CustomerCreateRequest request) {
        customerDatabase.save(new Customer(request.name()));
        return HttpStatus.CREATED;
    }

    public CustomerCreateResponse findById(UUID id) {
        return customerDatabase.findById(id).orElseThrow();
    }
}
