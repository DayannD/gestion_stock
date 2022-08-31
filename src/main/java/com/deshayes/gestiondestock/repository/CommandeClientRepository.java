package com.deshayes.gestiondestock.repository;

import com.deshayes.gestiondestock.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer> {
}
