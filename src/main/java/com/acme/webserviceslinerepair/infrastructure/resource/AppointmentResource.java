package com.acme.webserviceslinerepair.infrastructure.resource;

import com.acme.webserviceslinerepair.domain.model.PaymentStatus;
import com.acme.webserviceslinerepair.domain.model.Status;
import com.acme.webserviceslinerepair.domain.values.Address;
import com.acme.webserviceslinerepair.domain.values.Money;
import lombok.*;

@Setter
@Getter
@With
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResource {
    private Long id;
    private String dateReserve;
    private Address address;
    private String dateAttention;
    private String hour;
    private Status status;
    private Money reparationCost;
    private PaymentStatus paymentStatus;
    private ClientResource client;
    private ApplianceModelResource applianceModel;
}

