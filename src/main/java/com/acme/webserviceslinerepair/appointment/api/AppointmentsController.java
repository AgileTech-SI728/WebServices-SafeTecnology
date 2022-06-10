package com.acme.webserviceslinerepair.appointment.api;

import com.acme.webserviceslinerepair.applianceModel.resource.ApplianceModelResource;
import com.acme.webserviceslinerepair.appointment.domain.service.AppointmentService;
import com.acme.webserviceslinerepair.appointment.mapping.AppointmentMapper;
import com.acme.webserviceslinerepair.appointment.resource.AppointmentResource;
import com.acme.webserviceslinerepair.appointment.resource.CreateAppointmentResource;
import com.acme.webserviceslinerepair.appointment.resource.UpdateAppointmentResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Appointment")
@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class AppointmentsController {
    @Autowired
    private final AppointmentService appointmentService;

    @Autowired
    private final AppointmentMapper mapper;
    public AppointmentsController(AppointmentService appointmentService, AppointmentMapper mapper){
        this.appointmentService = appointmentService;
        this.mapper = mapper;
    }
    @Operation(summary = "Get All Appointments", description = "Get All Appointments")
    @GetMapping("appointments")
    public List<AppointmentResource> getAll(){
        return mapper.toResource(appointmentService.getAll());
    }

    @Operation(summary = "Get Appointment by Id", description = "Get Appointment by Id")
    @GetMapping("appointments/{appointmentId}")
    public AppointmentResource getAppointmentById(@PathVariable Long appointmentId){
        return mapper.toResource(appointmentService.getById(appointmentId));
    }
    @GetMapping
    public Page<AppointmentResource> getAllRents(Pageable pageable) {
        return mapper.modelListToPage(appointmentService.getAll(), pageable);
    }
    @Operation(summary = "Get Appointments by ClientId", description = "Get All Appointments by ClientId")
    @GetMapping("clients/{clientId}/appointments")
    public List<AppointmentResource> getAppointmentsByClientId(@PathVariable Long clientId){
        return mapper.toResource(appointmentService.getByClientId(clientId));
    }

    @Operation(summary = "Create New Appointment", description = "Create New Appointment")
    @PostMapping("clients/{clientId}/applianceModel/{applianceModelId}/appointments")
    public AppointmentResource createAppointment(@RequestBody CreateAppointmentResource model, @PathVariable Long clientId, @PathVariable Long applianceModelId){
        return mapper.toResource(appointmentService.create(mapper.toModel(model), clientId, applianceModelId));
    }

    @Operation(summary = "Update Appointment", description = "Update Appointment")
    @PutMapping("appointments/{appointmentId}")
    public AppointmentResource updateAppointment(@PathVariable Long appointmentId, @RequestBody UpdateAppointmentResource model){
        return mapper.toResource(appointmentService.update(appointmentId, mapper.toModel(model)));
    }

    @Operation(summary = "Delete Appointment", description = "Delete Appointment")
    @DeleteMapping("{appointmentId}")
    public ResponseEntity<?> deleteAppointment(@PathVariable Long appointmentId){
        return appointmentService.delete(appointmentId);
    }

}
