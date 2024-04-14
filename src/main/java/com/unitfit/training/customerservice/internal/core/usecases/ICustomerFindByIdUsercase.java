package com.unitfit.training.customerservice.internal.core.usecases;

import java.util.UUID;

public interface ICustomerFindByIdUsercase {
    void execute(UUID id);
}
