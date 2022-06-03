package com.acme.webserviceslinerepair.client.domain.persistence;

import com.acme.webserviceslinerepair.client.domain.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByEmail(String email);
        List<Client> findByNameAndLastNameContaining(String names, String lastNames);

        }
