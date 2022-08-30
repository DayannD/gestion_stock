package com.deshayes.gestiondestock.service.Iservice;

import com.deshayes.gestiondestock.dto.ArticleDto;
import com.deshayes.gestiondestock.dto.ClientDto;

import java.util.List;

public interface IClientService {

    ClientDto save(ClientDto clientDto);

    ClientDto findById(Integer id);

    List<ClientDto> findAll();

    void delete(Integer id);
}
