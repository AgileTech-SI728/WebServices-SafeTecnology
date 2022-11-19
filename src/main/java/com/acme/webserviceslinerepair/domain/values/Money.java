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
public class Money {
    @NotNull
    private Integer amount;

    @NotNull
    @NotBlank
    private String currency;
}