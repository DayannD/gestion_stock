package com.deshayes.gestiondestock.dto;

import com.deshayes.gestiondestock.model.Article;
import com.deshayes.gestiondestock.model.CommandeClient;
import com.deshayes.gestiondestock.model.LigneCommandeClient;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeClientDto {

    private Integer id;

    private Article article;

    private CommandeClient commandeClient;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;


    public static LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient){
        if(ligneCommandeClient == null)
            return null;

        return LigneCommandeClientDto.builder()
                .id(ligneCommandeClient.getId())
                .article(ligneCommandeClient.getArticle())
                .commandeClient(ligneCommandeClient.getCommandeClient())
                .quantite(ligneCommandeClient.getQuantite())
                .prixUnitaire(ligneCommandeClient.getPrixUnitaire())
                .build();
    }

    public static LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto){
        if(ligneCommandeClientDto == null)
            return null;

        return LigneCommandeClient.builder()
                .id(ligneCommandeClientDto.getId())
                .article(ligneCommandeClientDto.getArticle())
                .commandeClient(ligneCommandeClientDto.getCommandeClient())
                .quantite(ligneCommandeClientDto.getQuantite())
                .prixUnitaire(ligneCommandeClientDto.getPrixUnitaire())
                .build();
    }
}
