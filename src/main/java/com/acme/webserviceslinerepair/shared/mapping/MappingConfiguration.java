package com.acme.webserviceslinerepair.shared.mapping;

import com.acme.webserviceslinerepair.infrastructure.mapping.ApplianceModelMapper;
import com.acme.webserviceslinerepair.infrastructure.mapping.AppointmentMapper;
import com.acme.webserviceslinerepair.infrastructure.mapping.ClientMapper;
import com.acme.webserviceslinerepair.infrastructure.mapping.ReportMapper;
import com.acme.webserviceslinerepair.infrastructure.mapping.TechnicianMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("linerepairModelMapperConfiguration")
public class MappingConfiguration {
    @Bean
    public EnhancedModelMapper modelMapper() {
        return new EnhancedModelMapper();
    }

    @Bean
    public ClientMapper clientMapper() { return new ClientMapper(); }

    @Bean
    public TechnicianMapper technicianMapper() { return new TechnicianMapper(); }

    @Bean
    public  ReportMapper reportMapper() {return new ReportMapper(); }

    @Bean
    public ApplianceModelMapper applianceModelMapper() {return new ApplianceModelMapper();}

    @Bean
    public AppointmentMapper appointmentMapper() { return new AppointmentMapper(); }
}