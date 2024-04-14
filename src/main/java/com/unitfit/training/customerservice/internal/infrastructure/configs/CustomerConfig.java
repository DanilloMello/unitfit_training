package com.unitfit.training.customerservice.internal.infrastructure.configs;

import com.unitfit.training.customerservice.internal.core.factories.CustomerFactory;
import com.unitfit.training.customerservice.internal.core.usecases.CustomerCreateUsercaseImpl;
import com.unitfit.training.customerservice.internal.core.usecases.CustomerFindByIdUsercaseImpl;
import com.unitfit.training.customerservice.internal.core.usecases.ICustomerCreateUsercase;
import com.unitfit.training.customerservice.internal.core.usecases.ICustomerFindByIdUsercase;
import com.unitfit.training.customerservice.internal.infrastructure.presenters.CustomerRestPresenter;
import com.unitfit.training.customerservice.internal.infrastructure.repositories.CustomerJPADatabaseGateway;
import com.unitfit.training.customerservice.internal.infrastructure.repositories.CustomerJPARepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.context.WebApplicationContext;

@Configuration
@ComponentScan(basePackages = {"com.unitfit.training.customerservice"})
public class CustomerConfig {

    @Scope(WebApplicationContext.SCOPE_REQUEST)
    @Bean(autowireCandidate = false)
    public ICustomerCreateUsercase customerCreateUsecaseBean(
            HttpServletResponse httpServletResponse,
            MappingJackson2HttpMessageConverter jacksonConverter,
            CustomerJPARepository customerJPARepository) {
        return new CustomerCreateUsercaseImpl(
                new CustomerRestPresenter(
                        httpServletResponse,
                        jacksonConverter),
                new CustomerFactory(
                        new CustomerJPADatabaseGateway(customerJPARepository)
                )
        );
    }

    @Scope(WebApplicationContext.SCOPE_REQUEST)
    @Bean(autowireCandidate = false)
    public ICustomerFindByIdUsercase customerFindByIdUsercaseBean(
            HttpServletResponse httpServletResponse,
            MappingJackson2HttpMessageConverter jacksonConverter,
            CustomerJPARepository customerJPARepository) {
        return new CustomerFindByIdUsercaseImpl(
                new CustomerRestPresenter(
                        httpServletResponse,
                        jacksonConverter),
                new CustomerFactory(
                        new CustomerJPADatabaseGateway(customerJPARepository)
                )
        );
    }
}
