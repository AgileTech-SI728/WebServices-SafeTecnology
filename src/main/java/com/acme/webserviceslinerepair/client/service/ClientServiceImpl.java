package com.acme.webserviceslinerepair.client.service;

import com.acme.webserviceslinerepair.client.domain.model.entity.Client;
import com.acme.webserviceslinerepair.client.domain.persistence.ClientRepository;
import com.acme.webserviceslinerepair.client.domain.service.ClientService;
import com.acme.webserviceslinerepair.shared.exception.ResourceNotFoundException;
import com.acme.webserviceslinerepair.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

public class ClientServiceImpl implements ClientService {
    private final static String ENTITY = "Client";

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private Validator validator;

    @Override
    public List<Client> getAll(){return clientRepository.findAll();}

    @Override
    public Page<Client> getAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    @Override
    public Client getById(Long clientId){
        return clientRepository.findById(clientId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, clientId));
    }

    @Override
    public Client getByEmail(String email){
        return clientRepository.findByEmail(email);
    }

    @Override
    public List<Client> getByNameAndLastName(String names, String lastNames){
        return clientRepository.findByNameAndLastNameContaining(names, lastNames);
    }

    @Override
    public Client create(Client request){
        Set<ConstraintViolation<Client>> violations = validator.validate(request);
        if(!violations.isEmpty())
        throw new ResourceValidationException(ENTITY, violations);

        try{
            return clientRepository.save(request);
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while saving client");
        }
    }

    @Override
    public Client update(Long clientId, Client request){
        Set<ConstraintViolation<Client>> violations = validator.validate(request);
        if(!violations.isEmpty())
         throw new ResourceValidationException(ENTITY, violations);

        try{
            return clientRepository.findById(clientId)
                    .map(client->
                            clientRepository.save(
                                    client.withNames(request.getNames())
                                            .withLastNames(request.getLastNames())
                                            .withEmail(request.getEmail())
                                            .withPassword(request.getPassword())
                                            .withAddress(request.getAddress())
                                            .withCellPhoneNumber(request.getCellPhoneNumber())
                                            .withPlanType(request.getPlanType())
                            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, clientId));
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating client");
        }
    }

    @Override
    public ResponseEntity<?> delete(Long clientId) {
        return clientRepository.findById(clientId).map(client -> {
            clientRepository.delete(client);
                    return ResponseEntity.ok().build();
                }
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, clientId));
    }

}
