package com.deshayes.gestiondestock.service.Iservice;

import com.deshayes.gestiondestock.dto.ClientDto;
import com.deshayes.gestiondestock.dto.EntrepriseDto;
import com.deshayes.gestiondestock.model.Entreprise;

import java.util.List;

public interface IEntrepriseService {


    EntrepriseDto save(Entreprise entreprise);

    EntrepriseDto findById(Integer id);

    List<EntrepriseDto> findAll();

    void delete(Integer id);

}
