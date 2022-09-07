package com.deshayes.gestiondestock.repository;

import com.deshayes.gestiondestock.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer> {

    Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);
}
