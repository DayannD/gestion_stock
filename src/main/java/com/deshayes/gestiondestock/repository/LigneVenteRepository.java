package com.deshayes.gestiondestock.repository;

import com.deshayes.gestiondestock.model.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneVenteRepository extends JpaRepository<Integer, LigneVente> {
}
