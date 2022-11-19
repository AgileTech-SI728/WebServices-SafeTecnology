package com.acme.webserviceslinerepair.infrastructure.resource;

import com.acme.webserviceslinerepair.domain.model.PaymentStatus;
import com.acme.webserviceslinerepair.domain.model.Status;
import com.acme.webserviceslinerepair.domain.values.Address;
import com.acme.webserviceslinerepair.domain.values.Money;
import lombok.*;

import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Setter
@Getter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateAppointmentResource {
    @NotNull
    @NotBlank
    private String dateReserve;

    @Embedded
    private Address address;

    @NotNull
    @NotBlank
    private String dateAttention;

    @NotNull
    @NotBlank
    private String hour;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Embedded
    private Money reparationCost;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;

}
