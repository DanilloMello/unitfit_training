package com.unitfit.training.customerservice.internal.infrastructure.utils.dtos;

import static java.util.Objects.isNull;

public record CustomerCreateRequest(String name)
{
    public CustomerCreateRequest {
        if (isNull(name)) {
            throw new IllegalArgumentException("Customer's name can't be null");
        }
    }
}