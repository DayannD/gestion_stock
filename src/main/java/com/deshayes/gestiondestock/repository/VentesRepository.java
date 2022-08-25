package com.deshayes.gestiondestock.repository;

import com.deshayes.gestiondestock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentesRepository extends JpaRepository<Integer, Ventes> {
}
