package com.acme.webserviceslinerepair.appointment.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentResource {
    private Long id;
    private String dateReserve;
    private String dateAttention;
    private String hour;
    private ClientResource client;
    private ApplianceModelResource applianceModel;
}

