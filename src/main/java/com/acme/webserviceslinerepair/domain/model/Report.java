package com.acme.webserviceslinerepair.domain.model;

import com.acme.webserviceslinerepair.domain.values.ApplianceInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "technician_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Technician technician;

}

