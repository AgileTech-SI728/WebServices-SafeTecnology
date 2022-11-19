package com.acme.webserviceslinerepair.infrastructure.resource;

import com.acme.webserviceslinerepair.domain.values.ApplianceInfo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
public class UpdateReportResource {
    private Long id;
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
