package com.acme.webserviceslinerepair.application.service;

import com.acme.webserviceslinerepair.domain.model.Client;
import com.acme.webserviceslinerepair.infrastructure.repositories.ClientRepository;
import com.acme.webserviceslinerepair.infrastructure.service.ClientService;
import com.acme.webserviceslinerepair.exception.ResourceNotFoundException;
import com.acme.webserviceslinerepair.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {
    private static final String ENTITY = "Client";

    private final ClientRepository clientRepository;

    private final Validator validator;

    public ClientServiceImpl(ClientRepository clientRepository, Validator validator) {
        this.clientRepository = clientRepository;
        this.validator = validator;
    }

    @Override
    public List<Client> getAll(){return clientRepository.findAll();}

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
    public Page<Client> getAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }


    @Override
    public List<Client> getByNameAndLastName(String names, String lastNames){
        return clientRepository.findByNamesAndLastNamesContaining(names, lastNames);
    }

    @Override
    public Client create(Client client) {
        Set<ConstraintViolation<Client>> violations = validator.validate(client);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);


        try{
            return clientRepository.save(client);
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
                                    client.withFullName(request.getFullName())
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
