package com.acme.webserviceslinerepair.infrastructure.repositories;

import com.acme.webserviceslinerepair.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByEmail(String email);
    List<Client> findByNamesAndLastNamesContaining(String names, String lastNames);

}
