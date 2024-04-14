package com.unitfit.training.customerservice.internal.infrastructure.repositories;

import com.unitfit.training.customerservice.internal.core.domains.Customer;
import com.unitfit.training.customerservice.internal.infrastructure.utils.dtos.CustomerCreateResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface CustomerJPARepository extends JpaRepository<Customer, UUID> {

    @Query("""
                SELECT new com.unitfit.training.customerservice.internal.infrastructure.utils.dtos.CustomerCreateResponse
                ( c.id as id, c.name as name )
                FROM Customer c WHERE c.id = :id
            """)
    CustomerCreateResponse findCustomerById(@Param("id") UUID id);
}