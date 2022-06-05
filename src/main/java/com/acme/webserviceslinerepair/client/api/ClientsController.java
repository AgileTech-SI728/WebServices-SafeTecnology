package com.acme.webserviceslinerepair.client.api;

import com.acme.webserviceslinerepair.client.domain.service.ClientService;
import com.acme.webserviceslinerepair.client.mapping.ClientMapper;
import com.acme.webserviceslinerepair.client.resource.ClientResource;
import com.acme.webserviceslinerepair.client.resource.CreateClientResource;
import com.acme.webserviceslinerepair.client.resource.UpdateClientResource;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/clients")
public class ClientsController {
    @Autowired
    private final ClientService clientService;
    @Autowired
    private final ClientMapper mapper;

    public ClientsController(ClientService clientService, ClientMapper mapper) {
        this.clientService = clientService;
        this.mapper = mapper;
    }


    @Operation(summary = "Get All Clients", description = "Get All Clients")
    @GetMapping("clients")
    public List<ClientResource> getAll(){
        return mapper.toResource(clientService.getAll());
    }
    @Operation(summary = "Get Client by Email", description = "Get Client by Email")
    @GetMapping("emails/{email}")
    public ClientResource getClientByEmail(@PathVariable String email){
        return mapper.toResource(clientService.getByEmail(email));
    }
    @Operation(summary = "Get Client by Complete Name", description = "Get Client by Complete Name")
    @GetMapping("names/{names}/lastNames/{lastNames}")
    public List<ClientResource> getClientByNameAndLastName(@PathVariable String names, @PathVariable String lastNames){
        return mapper.toResource(clientService.getByNameAndLastName(names, lastNames));
    }
    @Operation(summary = "Get Client by Id", description = "Get Client by Id")
    @GetMapping("clients/{clientId}")
    public ClientResource getClientById(@PathVariable Long clientId){
        return mapper.toResource(clientService.getById(clientId));
    }
    @Operation(summary = "Create New Client", description = "Create New Client")
    @PostMapping("clients")
    public ClientResource createClient(@RequestBody CreateClientResource resource){
        return mapper.toResource(clientService.create(mapper.toModel(resource)));
    }
    @Operation(summary = "Update Client", description = "Update Client")
    @PutMapping("clients/{clientId}")
    public ClientResource updateClient(@PathVariable Long clientId, @RequestBody UpdateClientResource model){
        return mapper.toResource(clientService.update(clientId, mapper.toModel(model)));
    }

    @Operation(summary = "Delete Client", description = "Delete Client")
    @DeleteMapping("{clientId}")
    public ResponseEntity<?> deleteClient(@PathVariable Long clientId){
        return clientService.delete(clientId);
    }

}
