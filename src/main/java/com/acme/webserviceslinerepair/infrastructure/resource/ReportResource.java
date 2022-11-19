package com.acme.webserviceslinerepair.infrastructure.resource;

import com.acme.webserviceslinerepair.domain.values.ApplianceInfo;
import lombok.*;

@Setter
@Getter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ReportResource {
    private Long id;
    private String observation;
    private String diagnosis;
    private String repairDescription;
    private String date;
    private ApplianceInfo applianceInfo;
    private TechnicianResource technician;
}
