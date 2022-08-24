package com.deshayes.gestiondestock.dto;

import com.deshayes.gestiondestock.model.Adresse;
import com.deshayes.gestiondestock.model.Entreprise;
import com.deshayes.gestiondestock.model.Roles;
import com.deshayes.gestiondestock.model.Utilisateur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@Builder
public class UtilisateurDto {

    private Integer id;

    private String nom;

    private String prenom;

    private String email;

    private Instant dateDeNaissance;

    private String motDePasse;

    private Adresse adresse;

    private String photo;

    private Entreprise entreprise;

    @JsonIgnore
    private List<Roles> roles;


    public UtilisateurDto fromEntity(Utilisateur utilisateur){
        if (utilisateur == null)
            return null;

        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .email(utilisateur.getEmail())
                .dateDeNaissance(utilisateur.getDateDeNaissance())
                .motDePasse(utilisateur.getMotDePasse())
                .adresse(utilisateur.getAdresse())
                .photo(utilisateur.getPhoto())
                .entreprise(utilisateur.getEntreprise())
                .build();
    }

    public Utilisateur toEntity(UtilisateurDto utilisateurDto){
        if (utilisateurDto == null)
            return null;

        return Utilisateur.builder()
                .id(utilisateurDto.getId())
                .nom(utilisateurDto.getNom())
                .prenom(utilisateurDto.getPrenom())
                .email(utilisateurDto.getEmail())
                .dateDeNaissance(utilisateurDto.getDateDeNaissance())
                .motDePasse(utilisateurDto.getMotDePasse())
                .adresse(utilisateurDto.getAdresse())
                .photo(utilisateurDto.getPhoto())
                .entreprise(utilisateurDto.getEntreprise())
                .build();
    }
}
