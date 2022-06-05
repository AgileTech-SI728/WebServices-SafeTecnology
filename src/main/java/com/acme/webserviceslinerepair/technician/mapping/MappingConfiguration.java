package com.acme.webserviceslinerepair.technician.mapping;

import com.acme.webserviceslinerepair.client.mapping.ClientMapper;
import org.springframework.context.annotation.Bean;

public class MappingConfiguration {
    @Bean
    public TechnicianMapper technicianMapper(){
        return new TechnicianMapper();
    }
}

