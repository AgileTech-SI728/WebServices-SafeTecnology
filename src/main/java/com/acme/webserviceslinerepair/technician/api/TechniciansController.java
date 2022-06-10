package com.acme.webserviceslinerepair.technician.api;

import com.acme.webserviceslinerepair.technician.domain.service.TechnicianService;
import com.acme.webserviceslinerepair.technician.mapping.TechnicianMapper;
import com.acme.webserviceslinerepair.technician.resource.CreateTechnicianResource;
import com.acme.webserviceslinerepair.technician.resource.TechnicianResource;
import com.acme.webserviceslinerepair.technician.resource.UpdateTechnicianResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/technicians")
@CrossOrigin
public class TechniciansController {
    @Autowired
    private final TechnicianService technicianService;
    @Autowired
    private final TechnicianMapper mapper;

    public TechniciansController(TechnicianService technicianService, TechnicianMapper mapper) {
        this.technicianService = technicianService;
        this.mapper = mapper;
    }

    @Operation(summary = "Get All Technicians", description = "Get All Technicians")
    @GetMapping("technicians")
    public List<TechnicianResource> getAll(){
        return mapper.toResource(technicianService.getAll());
    }
    @Operation(summary = "Get Technician by Email", description = "Get Technician by Email")
    @GetMapping("emails/{email}")
    public TechnicianResource getTechnicianByEmail(@PathVariable String email){
        return mapper.toResource(technicianService.getByEmail(email));
    }
    @GetMapping
    public Page<TechnicianResource> getAllRents(Pageable pageable) {
        return mapper.modelListToPage(technicianService.getAll(), pageable);
    }
    @Operation(summary = "Get Technician by Complete Name", description = "Get Technician by Complete Name")
    @GetMapping("names/{names}/lastNames/{lastNames}")
    public List<TechnicianResource> getTechnicianByNameAndLastName(@PathVariable String names, @PathVariable String lastNames){
        return mapper.toResource(technicianService.getByNameAndLastName(names, lastNames));
    }
    @Operation(summary = "Get Technician by Id", description = "Get Technician by Id")
    @GetMapping("technicians/{technicianId}")
    public TechnicianResource getTechnicianById(@PathVariable Long technicianId){
        return mapper.toResource(technicianService.getById(technicianId));
    }
    @Operation(summary = "Create New Technician", description = "Create New Technician")
    @PostMapping("technicians")
    public TechnicianResource createTechnician(@RequestBody CreateTechnicianResource resource){
        return mapper.toResource(technicianService.create(mapper.toModel(resource)));
    }
    @Operation(summary = "Update Technician", description = "Update Technician")
    @PutMapping("technicians/{technicianId}")
    public TechnicianResource updateTechnician(@PathVariable Long technicianId, @RequestBody UpdateTechnicianResource model){
        return mapper.toResource(technicianService.update(technicianId, mapper.toModel(model)));
    }

    @Operation(summary = "Delete Technician", description = "Delete Technician")
    @DeleteMapping("{technicianId}")
    public ResponseEntity<?> deleteTechnician(@PathVariable Long technicianId){
        return technicianService.delete(technicianId);
    }

}

