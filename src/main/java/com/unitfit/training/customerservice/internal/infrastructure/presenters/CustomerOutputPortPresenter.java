package com.unitfit.training.customerservice.internal.infrastructure.presenters;

import com.unitfit.training.customerservice.internal.infrastructure.utils.dtos.CustomerCreateResponse;
import org.springframework.http.HttpStatus;

public interface CustomerOutputPortPresenter {
    void presentCreateUsecase(HttpStatus status);
    void presentFindByIdUsecase(CustomerCreateResponse response);
    void presentError(Exception exception);
}
