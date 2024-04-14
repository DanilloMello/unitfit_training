package com.unitfit.training.customerservice.internal.core.usecases;

import com.unitfit.training.customerservice.internal.core.factories.CustomerFactory;
import com.unitfit.training.customerservice.internal.infrastructure.presenters.CustomerRestPresenter;
import com.unitfit.training.customerservice.internal.infrastructure.utils.dtos.CustomerCreateResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class CustomerFindByIdUsercaseImpl implements ICustomerFindByIdUsercase {

    private final CustomerRestPresenter presenter;
    private final CustomerFactory factory;

    @Override
    @Transactional
    public void execute(UUID id) {
        try {
            CustomerCreateResponse customer = factory.findById(id);
            presenter.presentFindByIdUsecase(customer);
        } catch (Exception e){
            presenter.presentError(e);
        }
    }
}
