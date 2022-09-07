package com.deshayes.gestiondestock.repository;

import com.deshayes.gestiondestock.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {
}
