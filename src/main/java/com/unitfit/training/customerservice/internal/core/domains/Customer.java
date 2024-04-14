package com.unitfit.training.customerservice.internal.core.domains;

import com.unitfit.training.customerservice.internal.core.domains.constraints.DomainValidation;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
@Getter @Setter
@Entity
public class Customer extends DomainValidation {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    @NonNull
    private String name;

    @Override
    public Boolean isValid() {
        return true;
    }
}
