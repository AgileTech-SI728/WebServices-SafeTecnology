package com.acme.webserviceslinerepair.infrastructure.service;

import com.acme.webserviceslinerepair.domain.model.Technician;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TechnicianService {
    List<Technician> getAll();
    Technician getById(Long technicianId);
    Page<Technician> getAll(Pageable pageable);
    List<Technician> getByNameAndLastName(String names, String lastNames);
    Technician create(Technician technician);
    Technician update(Long technicianId, Technician technician);
    ResponseEntity<?> delete(Long technicianId);
}
