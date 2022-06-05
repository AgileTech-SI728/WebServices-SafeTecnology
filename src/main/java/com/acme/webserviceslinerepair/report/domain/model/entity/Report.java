package com.acme.webserviceslinerepair.report.domain.model.entity;

import com.acme.webserviceslinerepair.shared.domain.model.AuditModel;
import com.acme.webserviceslinerepair.technician.domain.model.entity.Technician;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "reports")
public class Report extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String observation;

    @NotNull
    @NotBlank
    private String diagnosis;

    @NotNull
    @NotBlank
    private String repairDescription;

    @NotNull
    @NotBlank
    private String date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "technician_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Technician technician;

}

