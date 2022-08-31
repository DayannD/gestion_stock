package com.deshayes.gestiondestock.service.Iservice;

import com.deshayes.gestiondestock.dto.ClientDto;
import com.deshayes.gestiondestock.dto.CommandeClientDto;

import java.util.List;

public interface ICommandeClientService {


    CommandeClientDto save(CommandeClientDto dto);

    CommandeClientDto findById(Integer id);
    CommandeClientDto findByCode(String code);

    List<CommandeClientDto> findAll();

    void delete(Integer id);

}
