package com.deshayes.gestiondestock.validator;

import com.deshayes.gestiondestock.dto.ClientDto;
import com.deshayes.gestiondestock.model.Client;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

    public static List<String> validate(ClientDto clientDto){

        List<String> errors = new ArrayList<>();

        if (clientDto == null){
            errors.add("Veuillez renseigner le nom du client");
            errors.add("Veuillez renseigner le prenom du client");
            errors.add("Veuillez renseigner l'email du client");
            errors.add("Veuillez renseigner l'adresse du client'");
            errors.add("Veuillez renseigner le téléphone du client");
            return errors;
        }
        if (!StringUtils.hasText(clientDto.getName())){
            errors.add("Veuillez renseigner le nom du client");
        }
        if (!StringUtils.hasText(clientDto.getPrenom())){
            errors.add("Veuillez renseigner le prenom du client");
        }
        if (!StringUtils.hasText(clientDto.getEmail())){
            errors.add("Veuillez renseigner l'email du client");
        }
        if (!StringUtils.hasText(clientDto.getAdresse().getAdresse1())){
            errors.add("Veuillez renseigner l'adresse du client'");
        }
        if (!StringUtils.hasText(clientDto.getTel())){
            errors.add("Veuillez renseigner le télèphone du client");
        }
        return errors;
    }
}
