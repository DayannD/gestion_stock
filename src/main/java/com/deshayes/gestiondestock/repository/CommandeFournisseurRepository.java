package com.deshayes.gestiondestock.repository;

import com.deshayes.gestiondestock.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeFournisseurRepository extends JpaRepository<Integer, CommandeFournisseur> {
}
