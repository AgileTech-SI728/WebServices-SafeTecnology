package com.acme.webserviceslinerepair.infrastructure.resource;

import com.acme.webserviceslinerepair.domain.values.Money;
import lombok.*;

import javax.persistence.Embedded;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateApplianceModelResource{
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String model;

    @NotNull
    @NotBlank
    private String imagePath;

    @Embedded
    private Money diagnosisCost;
}
