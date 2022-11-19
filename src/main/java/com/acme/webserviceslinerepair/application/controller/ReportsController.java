package com.acme.webserviceslinerepair.application.controller;

import com.acme.webserviceslinerepair.infrastructure.service.ReportService;
import com.acme.webserviceslinerepair.infrastructure.mapping.ReportMapper;
import com.acme.webserviceslinerepair.infrastructure.resource.CreateReportResource;
import com.acme.webserviceslinerepair.infrastructure.resource.ReportResource;
import com.acme.webserviceslinerepair.infrastructure.resource.UpdateReportResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Report")
@RestController
@RequestMapping("api/v1/reports")
@CrossOrigin
public class ReportsController {

    private final ReportService reportService;
    private final ReportMapper mapper;

    public ReportsController(ReportService reportService, ReportMapper mapper) {
        this.reportService = reportService;
        this.mapper = mapper;
    }


    @Operation(summary = "Get All Reports", description = "Get All Reports")
    @GetMapping("reports")
    public List<ReportResource> getAll(){
        return mapper.toResource(reportService.getAll());
    }
    @Operation(summary = "Get Report by Id", description = "Get Report by Id")
    @GetMapping("{reportId}")
    public ReportResource getReportById(@PathVariable Long reportId){
        return mapper.toResource(reportService.getById(reportId));
    }
    @Operation(summary = "Create New Report", description = "Create New Report")
    @PostMapping("{technicianId}/reports")
    public ReportResource createReport(@RequestBody CreateReportResource resource, @PathVariable Long technicianId){
        return mapper.toResource(reportService.create(mapper.toModel(resource), technicianId));
    }
    @Operation(summary = "Update Report", description = "Update Report")
    @PutMapping("{reportId}")
    public ReportResource updateReport(@PathVariable Long reportId, @RequestBody UpdateReportResource model){
        return mapper.toResource(reportService.update(reportId, mapper.toModel(model)));
    }

    @Operation(summary = "Delete Report", description = "Delete Report")
    @DeleteMapping("{reportId}")
    public ResponseEntity<?> deleteReport(@PathVariable Long reportId){
        return reportService.delete(reportId);
    }

}
