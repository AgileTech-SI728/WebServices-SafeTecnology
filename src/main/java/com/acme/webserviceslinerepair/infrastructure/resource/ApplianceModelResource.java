package com.acme.webserviceslinerepair.infrastructure.resource;

import com.acme.webserviceslinerepair.domain.values.Money;
import lombok.*;

@Setter
@Getter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ApplianceModelResource {
    private Long id;
    private String name;
    private String model;
    private String imagePath;
    private Money diagnosisCost;
    private ClientResource client;
}

