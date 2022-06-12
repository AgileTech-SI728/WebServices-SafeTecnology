package com.acme.webserviceslinerepair.applianceModel.api;

import com.acme.webserviceslinerepair.applianceModel.domain.service.ApplianceModelService;
import com.acme.webserviceslinerepair.applianceModel.mapping.ApplianceModelMapper;
import com.acme.webserviceslinerepair.applianceModel.resource.ApplianceModelResource;
import com.acme.webserviceslinerepair.applianceModel.resource.CreateApplianceModelResource;
import com.acme.webserviceslinerepair.applianceModel.resource.UpdateApplianceModelResource;
import com.acme.webserviceslinerepair.client.resource.ClientResource;
import com.acme.webserviceslinerepair.client.resource.CreateClientResource;
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

@Tag(name = "ApplianceModel")
@RestController
@RequestMapping("api/v1/applianceModels")
@CrossOrigin
public class ApplianceModelsController {
    @Autowired
    private final ApplianceModelService applianceModelService;

    @Autowired
    private final ApplianceModelMapper mapper;
    public ApplianceModelsController(ApplianceModelService applianceModelService, ApplianceModelMapper mapper){
        this.applianceModelService = applianceModelService;
        this.mapper = mapper;
    }
    @Operation(summary = "Get All ApplianceModels", description = "Get All ApplianceModels")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ApplianceModels found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApplianceModelResource.class))})
    })
    @GetMapping("applianceModels")
    public List<ApplianceModelResource> getAll(){
        return mapper.toResource(applianceModelService.getAll());
    }

    @Operation(summary = "Get ApplianceModel by Id", description = "Get ApplianceModel by Id")
    @GetMapping("{applianceModelId}")
    public ApplianceModelResource getApplianceModelById(@PathVariable Long applianceModelId){
        return mapper.toResource(applianceModelService.getById(applianceModelId));
    }
    @Operation(summary = "Get ApplianceModels by ClientId", description = "Get All ApplianceModels by ClientId")
    @GetMapping("{clientId}/applianceModels")
    public List<ApplianceModelResource> getApplianceModelsByClientId(@PathVariable Long clientId){
        return mapper.toResource(applianceModelService.getByClientId(clientId));
    }

    @Operation(summary = "Create New ApplianceModel", description = "Create New ApplianceModel")
    @PostMapping("{clientId}/applianceModels")
    public ApplianceModelResource createClient(@RequestBody CreateApplianceModelResource resource, @PathVariable Long clientId){
        return mapper.toResource(applianceModelService.create(mapper.toModel(resource), clientId));
    }
    @Operation(summary = "Update ApplianceModel", description = "Update ApplianceModel")
    @PutMapping("{applianceModelId}")
    public ApplianceModelResource updateApplianceModel(@PathVariable Long applianceModelId, @RequestBody UpdateApplianceModelResource model){
        return mapper.toResource(applianceModelService.update(applianceModelId, mapper.toModel(model)));
    }
    @Operation(summary = "Delete ApplianceModel", description = "Delete ApplianceModel")
    @DeleteMapping("{applianceModelId}")
    public ResponseEntity<?> deleteApplianceModel(@PathVariable Long applianceModelId){
        return applianceModelService.delete(applianceModelId);
    }

}
