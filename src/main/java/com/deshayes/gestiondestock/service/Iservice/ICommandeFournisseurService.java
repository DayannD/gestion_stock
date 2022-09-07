package com.deshayes.gestiondestock.service.Iservice;

import com.deshayes.gestiondestock.dto.CommandeClientDto;
import com.deshayes.gestiondestock.dto.CommandeFournisseurDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICommandeFournisseurService {


    CommandeFournisseurDto save(CommandeFournisseurDto dto);

    CommandeFournisseurDto findById(Integer id);
    CommandeFournisseurDto findByCode(String code);

    List<CommandeFournisseurDto> findAll();

    void delete(Integer id);

}
