package com.deshayes.gestiondestock.dto;

import com.deshayes.gestiondestock.model.Article;
import com.deshayes.gestiondestock.model.CommandeFournisseur;
import com.deshayes.gestiondestock.model.LigneCommandeClient;
import com.deshayes.gestiondestock.model.LigneCommandeFournisseur;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeFournisseurDto {

    private Integer id;

    private Article article;

    private CommandeFournisseur commandeFournisseur;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;


    public LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur){
        if(ligneCommandeFournisseur == null)
            return null;

        return LigneCommandeFournisseurDto.builder()
                .id(ligneCommandeFournisseur.getId())
                .article(ligneCommandeFournisseur.getArticle())
                .commandeFournisseur(ligneCommandeFournisseur.getCommandeFournisseur())
                .quantite(ligneCommandeFournisseur.getQuantite())
                .prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
                .build();
    }

    public LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto ligneCommandeFournisseurDto){
        if(ligneCommandeFournisseurDto == null)
            return null;

        return LigneCommandeFournisseur.builder()
                .id(ligneCommandeFournisseurDto.getId())
                .article(ligneCommandeFournisseurDto.getArticle())
                .commandeFournisseur(ligneCommandeFournisseurDto.getCommandeFournisseur())
                .quantite(ligneCommandeFournisseurDto.getQuantite())
                .prixUnitaire(ligneCommandeFournisseurDto.getPrixUnitaire())
                .build();
    }
}
