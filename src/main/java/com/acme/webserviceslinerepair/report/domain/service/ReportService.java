package com.acme.webserviceslinerepair.report.domain.service;

import com.acme.webserviceslinerepair.report.domain.model.entity.Report;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReportService {
    List<Report> getAll();
    Report getById(Long reportId);
    List<Report> getByTechnicianId(Long technicianId);
    Report create(Report report, Long technicianId);
    Report update(Long reportId, Report report);
    ResponseEntity<?> delete(Long reportId);
}
