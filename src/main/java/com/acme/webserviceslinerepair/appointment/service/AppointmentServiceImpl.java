package com.acme.webserviceslinerepair.appointment.service;

import com.acme.webserviceslinerepair.appointment.domain.model.entity.Appointment;
import com.acme.webserviceslinerepair.appointment.domain.persistence.AppointmentRepository;
import com.acme.webserviceslinerepair.appointment.domain.service.AppointmentService;
import com.acme.webserviceslinerepair.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AppointmentServiceImpl implements AppointmentService {
    private final static String ENTITY = "Appointment";
    private final static String ENTITY2 = "Client";
    private final static String ENTITY3 = "ApplianceModel";

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ApplianceModelRepository applianceModelRepository;

    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, appointmentId));
    }

    @Override
    public Appointment create(Appointment request, Long clientId, Long applianceModelId) {
        var client = clientRepository.findById(clientId);
        if(client.isEmpty())
            throw new ResourceNotFoundException(ENTITY2, clientId);

        var appliance = applianceModelRepository.findById(applianceModelId);
        if(appliance.isEmpty())
            throw new ResourceNotFoundException(ENTITY3, applianceModelId);

        request.setClient(client.get());
        request.setApplianceModel(applianceModel.get());
        return appointmentRepository.save(request);
    }

    @Override
    public Appointment update(Long appointmentId, Appointment request) {
        return appointmentRepository.findById(appointmentId)
                .map(appointment -> appointmentRepository.save(
                        appointment.withDateReserve(request.getDateReserve())
                                .withDateAttention(request.getDateAttention())
                                .withHour(request.getHour())
                )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, appointmentId));
    }

    @Override
    public Appointment delete(Long appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .map(appointment -> {
                    appointmentRepository.delete(appointment);
                    return appointment;
                }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, appointmentId));
    }

    @Override
    public List<Appointment> getByClientId(Long clientId) {
        var client = clientRepository.findById(clientId);
        if(client.isEmpty())
            throw new ResourceNotFoundException(ENTITY2, clientId);

        return appointmentRepository.findByClientId(clientId);
    }

}
