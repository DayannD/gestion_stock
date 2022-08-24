package com.deshayes.gestiondestock.dto;

import com.deshayes.gestiondestock.model.Adresse;
import com.deshayes.gestiondestock.model.CommandeFournisseur;
import com.deshayes.gestiondestock.model.Fournisseur;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
public class FournisseurDto {

    private Integer id;

    private String name;

    private String prenom;

    private Adresse adresse;

    private String photo;

    private String email;

    private String tel;

    private List<CommandeFournisseur> commandeFournisseur;


    public FournisseurDto fromEntity(Fournisseur fournisseur){
        if (fournisseur == null)
            return null;

        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .name(fournisseur.getName())
                .prenom(fournisseur.getPrenom())
                .adresse(fournisseur.getAdresse())
                .photo(fournisseur.getPhoto())
                .email(fournisseur.getEmail())
                .tel(fournisseur.getTel())
                .build();
    }

    public Fournisseur toEntity(FournisseurDto fournisseurDto){
        if (fournisseurDto == null)
            return null;

        return Fournisseur.builder()
                .id(fournisseurDto.getId())
                .name(fournisseurDto.getName())
                .prenom(fournisseurDto.getPrenom())
                .adresse(fournisseurDto.getAdresse())
                .photo(fournisseurDto.getPhoto())
                .email(fournisseurDto.getEmail())
                .tel(fournisseurDto.getTel())
                .build();
    }
}
