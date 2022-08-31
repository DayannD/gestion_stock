package com.deshayes.gestiondestock.service.Iservice;

import com.deshayes.gestiondestock.dto.EntrepriseDto;
import com.deshayes.gestiondestock.dto.FournisseurDto;
import com.deshayes.gestiondestock.model.Entreprise;
import com.deshayes.gestiondestock.model.Fournisseur;

import java.util.List;

public interface IFournisseurService {
    FournisseurDto save(Fournisseur fournisseur);

    FournisseurDto findById(Integer id);

    List<FournisseurDto> findAll();

    void delete(Integer id);
}
