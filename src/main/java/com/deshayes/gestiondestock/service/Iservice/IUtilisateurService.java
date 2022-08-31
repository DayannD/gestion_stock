package com.deshayes.gestiondestock.service.Iservice;

import com.deshayes.gestiondestock.dto.FournisseurDto;
import com.deshayes.gestiondestock.dto.UtilisateurDto;
import com.deshayes.gestiondestock.model.Fournisseur;
import com.deshayes.gestiondestock.model.Utilisateur;

import java.util.List;

public interface IUtilisateurService {

    UtilisateurDto save(Utilisateur utilisateur);

    UtilisateurDto findById(Integer id);

    List<UtilisateurDto> findAll();

    void delete(Integer id);

}
