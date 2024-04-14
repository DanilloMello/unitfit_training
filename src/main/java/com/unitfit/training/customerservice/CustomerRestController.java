package com.unitfit.training.customerservice;


import com.unitfit.training.customerservice.internal.core.usecases.ICustomerCreateUsercase;
import com.unitfit.training.customerservice.internal.core.usecases.ICustomerFindByIdUsercase;
import com.unitfit.training.customerservice.internal.infrastructure.utils.dtos.CustomerCreateRequest;
import jakarta.annotation.security.PermitAll;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
@PermitAll
public class CustomerRestController {

    private final ApplicationContext context;

    @PostMapping
    public void create(@RequestBody CustomerCreateRequest request){
        ICustomerCreateUsercase createUsecase = context.getBean(ICustomerCreateUsercase.class);
        createUsecase.execute(request);
    }

    @GetMapping("{id}")
    public void find(@PathVariable UUID id){
        ICustomerFindByIdUsercase findByIdUsecase = context.getBean(ICustomerFindByIdUsercase.class);
        findByIdUsecase.execute(id);
    }
}