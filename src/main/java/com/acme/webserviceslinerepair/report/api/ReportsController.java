package com.acme.webserviceslinerepair.report.api;

import com.acme.webserviceslinerepair.report.domain.service.ReportService;
import com.acme.webserviceslinerepair.report.mapping.ReportMapper;
import com.acme.webserviceslinerepair.report.resource.CreateReportResource;
import com.acme.webserviceslinerepair.report.resource.ReportResource;
import com.acme.webserviceslinerepair.report.resource.UpdateReportResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Report")
@RestController
@RequestMapping("api/v1/reports")
@CrossOrigin
public class ReportsController {
    @Autowired
    private final ReportService reportService;
    @Autowired
    private final ReportMapper mapper;

    public ReportsController(ReportService reportService, ReportMapper mapper) {
        this.reportService = reportService;
        this.mapper = mapper;
    }


    @Operation(summary = "Get All Reports", description = "Get All Reports")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reports found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ReportResource.class))})
    })
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
