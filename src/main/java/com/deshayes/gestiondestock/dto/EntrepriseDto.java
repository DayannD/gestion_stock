package com.deshayes.gestiondestock.dto;

import com.deshayes.gestiondestock.model.Adresse;
import com.deshayes.gestiondestock.model.Entreprise;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embedded;

@Data
@Builder
public class EntrepriseDto {

    private Integer id;

    private String nom;

    private String description;

    private Adresse adresse;

    private String codeFiscal;

    private String photo;

    private String email;

    private String tel;

    public EntrepriseDto fromEntity(Entreprise entreprise){
        if(entreprise ==  null)
            return null;

        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .description(entreprise.getDescription())
                .adresse(entreprise.getAdresse())
                .codeFiscal(entreprise.getCodeFiscal())
                .photo(entreprise.getPhoto())
                .email(entreprise.getEmail())
                .tel(entreprise.getTel())
                .build();
    }

    public Entreprise toEntity(EntrepriseDto entrepriseDto){
        if(entrepriseDto ==  null)
            return null;

        return Entreprise.builder()
                .id(entrepriseDto.getId())
                .nom(entrepriseDto.getNom())
                .description(entrepriseDto.getDescription())
                .adresse(entrepriseDto.getAdresse())
                .codeFiscal(entrepriseDto.getCodeFiscal())
                .photo(entrepriseDto.getPhoto())
                .email(entrepriseDto.getEmail())
                .tel(entrepriseDto.getTel())
                .build();
    }
}
