package com.deshayes.gestiondestock.validator;

import com.deshayes.gestiondestock.dto.ArticleDto;
import com.deshayes.gestiondestock.dto.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {

    public static List<String> validate(CommandeClientDto dto){
        List<String> errors = new ArrayList<>();

        if (dto == null){
            errors.add("Veuillez renseigner le code de l'article");
            errors.add("Veuillez renseigner le code de l'article");
            errors.add("Veuillez renseigner le prix Unitaire HT de l'article");
            errors.add("Veuillez renseigner le taux de Tva de l'article");
            errors.add("Veuillez renseigner le prix unitaire TTC de l'article");
            errors.add("Veuillez renseigner la catégorie de l'article");
            return errors;
        }

        if (dto.getClient() == null){
            errors.add("Il n'y a pas de client");
        }
        if (dto.getCode() == null){
            errors.add("le code n'est pas renseigner");
        }
        if (!dto.getLigneCommandeClients()){
            errors.add("Veuillez renseigner le prix Unitaire HT de l'article");
        }
        if (articleDto.getTauxTva() == null){
            errors.add("Veuillez renseigner le taux de Tva de l'article");
        }
        if (articleDto.getPrixUnitaireTtc() == null){
            errors.add("Veuillez renseigner le prix unitaire TTC de l'article");
        }
        if (articleDto.getCategory() == null){
            errors.add("Veuillez renseigner la catégorie de l'article");
        }
        return errors;
    }
}
