package com.acme.webserviceslinerepair.infrastructure.resource;

import com.acme.webserviceslinerepair.domain.values.ApplianceInfo;
import lombok.*;

import javax.persistence.Embedded;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateReportResource {
    @NotNull
    @NotBlank
    @Size(max=600)
    private String observation;

    @NotNull
    @NotBlank
    @Size(max=700)
    private String diagnosis;

    @NotNull
    @NotBlank
    @Size(max=700)
    private String repairDescription;

    @NotNull
    @NotBlank
    @Size(max=40)
    private String date;

    @Embedded
    private ApplianceInfo applianceInfo;
}
