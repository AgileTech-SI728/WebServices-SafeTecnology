package com.acme.webserviceslinerepair.applianceModel.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("applianceModelMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public ApplianceModelMapper applianceModelMapper(){
        return new ApplianceModelMapper();
    }
}
