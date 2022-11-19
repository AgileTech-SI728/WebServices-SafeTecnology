package com.acme.webserviceslinerepair.infrastructure.repositories;

import com.acme.webserviceslinerepair.domain.model.ApplianceModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplianceModelRepository extends JpaRepository<ApplianceModel, Long> {
    List<ApplianceModel> findByName(String name);
    List<ApplianceModel> findByClientId(Long clientId);
}
