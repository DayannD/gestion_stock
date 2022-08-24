package com.deshayes.gestiondestock.dto;

import com.deshayes.gestiondestock.model.Adresse;
import com.deshayes.gestiondestock.model.Article;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class AdresseDto {

    private String adresse1;

    private String adresse2;

    private String ville;

    private String codePostale;

    private String pays;


    public AdresseDto fromEntity(Adresse adresse){
        if (adresse == null)
            return null;

        return AdresseDto.builder()
                .adresse1(adresse.getAdresse1())
                .adresse2(adresse.getAdresse2())
                .ville(adresse.getVille())
                .codePostale(adresse.getCodePostale())
                .pays(adresse.getPays())
                .build();
    }

    public Adresse fromEntity(AdresseDto adresseDto){
        if (adresseDto == null)
            return null;

        return Adresse.builder()
                .adresse1(adresseDto.getAdresse1())
                .adresse2(adresseDto.getAdresse2())
                .ville(adresseDto.getVille())
                .codePostale(adresseDto.getCodePostale())
                .pays(adresseDto.getPays())
                .build();
    }
}
