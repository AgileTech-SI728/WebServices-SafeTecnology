package com.acme.webserviceslinerepair.infrastructure.service;

import com.acme.webserviceslinerepair.domain.model.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReportService {
    List<Report> getAll();
    Report getById(Long reportId);
    Page<Report> getAll(Pageable pageable);
    List<Report> getByTechnicianId(Long technicianId);
    Report create(Report report, Long technicianId);
    Report update(Long reportId, Report report);
    ResponseEntity<?> delete(Long reportId);
}
