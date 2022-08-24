package com.deshayes.gestiondestock.dto;

import com.deshayes.gestiondestock.model.LigneVente;
import com.deshayes.gestiondestock.model.Ventes;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@Builder
public class LigneVenteDto {

    private Integer id;

    private Ventes ventes;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;


    public LigneVenteDto fromEntity(LigneVente ligneVente){
        if(ligneVente == null)
            return null;

        return LigneVenteDto.builder()
                .id(ligneVente.getId())
                .ventes(ligneVente.getVentes())
                .quantite(ligneVente.getQuantite())
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .build();
    }

    public LigneVente toEntity(LigneVenteDto ligneVenteDto){
        if(ligneVenteDto == null)
            return null;

        return LigneVente.builder()
                .id(ligneVenteDto.getId())
                .ventes(ligneVenteDto.getVentes())
                .quantite(ligneVenteDto.getQuantite())
                .prixUnitaire(ligneVenteDto.getPrixUnitaire())
                .build();
    }
}
