package com.acme.webserviceslinerepair.technician.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("technicianMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public TechnicianMapper technicianMapper(){
        return new TechnicianMapper();
    }
}

