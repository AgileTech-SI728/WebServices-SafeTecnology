package com.acme.webserviceslinerepair.appointment.resource;

import com.acme.webserviceslinerepair.applianceModel.resource.ApplianceModelResource;
import com.acme.webserviceslinerepair.client.resource.ClientResource;
import lombok.*;


@Setter
@Getter
@With
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentResource {
    private Long id;
    private String dateReserve;
    private String dateAttention;
    private String hour;
    private ClientResource client;
    private ApplianceModelResource applianceModel;
}

