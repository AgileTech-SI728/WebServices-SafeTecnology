package com.acme.webserviceslinerepair.infrastructure.repositories;

import com.acme.webserviceslinerepair.domain.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByTechnicianId(Long technicianId);

}
