package com.acme.webserviceslinerepair.domain.values;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApplianceInfo {
    @NotNull
    @NotBlank
    private String type;

    @NotNull
    @NotBlank
    private String model;

    @NotNull
    @NotBlank
    private String brand;
}
