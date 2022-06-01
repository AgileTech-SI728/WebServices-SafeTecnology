package com.acme.webserviceslinerepair.appointment.domain.service;

import com.acme.webserviceslinerepair.appointment.domain.model.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAll();
    Appointment getById(Long appointmentId);
    Appointment create(Appointment appointment, Long clientId, Long applianceModelId);
    Appointment update(Long appointmentId, Appointment appointment);
    Appointment delete(Long appointmentId);
    List<Appointment> getByClientId(Long clientId);

}
