package com.deshayes.gestiondestock.validator;

import com.deshayes.gestiondestock.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public static List<String> validate(UtilisateurDto utilisateurDto){

        List<String> errors = new ArrayList<>();

        if (utilisateurDto == null){
            errors.add("Veuillez renseigner le nom de l'utilisateur");
            errors.add("Veuillez renseigner le prenom de l'utilisateur");
            errors.add("Veuillez renseigner le email de l'utilisateur");
            errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
            errors.add("Veuillez renseigner l'adresse de l'utilisateur");
            errors.add("Veuillez renseigner la ville de l'utilisateur");
            errors.add("Veuillez renseigner le code postale de l'utilisateur");
            errors.add("Veuillez renseigner le pays de l'utilisateur");
            return errors;
        }
        if (!StringUtils.hasText(utilisateurDto.getNom())){
            errors.add("Veuillez renseigner le nom de l'utilisateur");
        }
        if (!StringUtils.hasText(utilisateurDto.getPrenom())){
            errors.add("Veuillez renseigner le prenom de l'utilisateur");
        }
        if (!StringUtils.hasText(utilisateurDto.getEmail())){
            errors.add("Veuillez renseigner le email de l'utilisateur");
        }
        if (!StringUtils.hasText(utilisateurDto.getMotDePasse())){
            errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
        }
        if (!StringUtils.hasText(utilisateurDto.getAdresse().getAdresse1())){
            errors.add("Veuillez renseigner l'adresse de l'utilisateur");
        }
        if (!StringUtils.hasText(utilisateurDto.getAdresse().getVille())){
            errors.add("Veuillez renseigner la ville de l'utilisateur");
        }
        if (!StringUtils.hasText(utilisateurDto.getAdresse().getCodePostale())){
            errors.add("Veuillez renseigner le code postale de l'utilisateur");
        }
        if (!StringUtils.hasText(utilisateurDto.getAdresse().getPays())){
            errors.add("Veuillez renseigner le pays de l'utilisateur");
        }

        return errors;
    }
}
