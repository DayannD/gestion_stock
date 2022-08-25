package com.deshayes.gestiondestock.repository;

import com.deshayes.gestiondestock.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Integer, Fournisseur> {
}
