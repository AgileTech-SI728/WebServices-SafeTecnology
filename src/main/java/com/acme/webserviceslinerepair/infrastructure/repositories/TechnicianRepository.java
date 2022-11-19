package com.acme.webserviceslinerepair.infrastructure.repositories;

import com.acme.webserviceslinerepair.domain.model.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechnicianRepository extends JpaRepository<Technician, Long> {
    List<Technician> findByNamesAndLastNamesContaining(String names, String lastNames);

}
