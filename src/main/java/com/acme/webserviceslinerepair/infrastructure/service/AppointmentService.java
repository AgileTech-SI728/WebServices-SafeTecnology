package com.acme.webserviceslinerepair.infrastructure.service;

import com.acme.webserviceslinerepair.domain.model.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAll();
    Appointment getById(Long appointmentId);
    Page<Appointment> getAll(Pageable pageable);
    Appointment create(Appointment appointment, Long clientId, Long applianceModelId);
    Appointment update(Long appointmentId, Appointment appointment);
    ResponseEntity<?> delete(Long appointmentId);
    List<Appointment> getByClientId(Long clientId);
    Page<Appointment> getAllByClientId(Long clientId,Pageable pageable);

}
