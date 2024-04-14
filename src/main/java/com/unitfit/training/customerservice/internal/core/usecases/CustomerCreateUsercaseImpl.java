package com.unitfit.training.customerservice.internal.core.usecases;

import com.unitfit.training.customerservice.internal.core.factories.CustomerFactory;
import com.unitfit.training.customerservice.internal.infrastructure.presenters.CustomerRestPresenter;
import com.unitfit.training.customerservice.internal.infrastructure.utils.dtos.CustomerCreateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public class CustomerCreateUsercaseImpl implements ICustomerCreateUsercase {

    private final CustomerRestPresenter presenter;
    private final CustomerFactory factory;

    @Override
    @Transactional
    public void execute(CustomerCreateRequest request) {
        try {
            HttpStatus status = factory.create(request);
            presenter.presentCreateUsecase(status);
        } catch (Exception e){
            presenter.presentError(e);
        }
    }
}
