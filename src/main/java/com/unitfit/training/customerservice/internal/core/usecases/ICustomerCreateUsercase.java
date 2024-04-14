package com.unitfit.training.customerservice.internal.core.usecases;

import com.unitfit.training.customerservice.internal.infrastructure.utils.dtos.CustomerCreateRequest;

public interface ICustomerCreateUsercase {
    void execute(CustomerCreateRequest request);
}
