package com.deshayes.gestiondestock.dto;

import com.deshayes.gestiondestock.model.CommandeFournisseur;
import com.deshayes.gestiondestock.model.Fournisseur;
import com.deshayes.gestiondestock.model.LigneCommandeFournisseur;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandeFournisseurDto {

    private Integer id;

    private String code;

    private Instant dateCommande;

    private Fournisseur fournisseur;

    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;


    public CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur){
        if(commandeFournisseur == null)
            return null;

        return CommandeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .code(commandeFournisseur.getCode())
                .dateCommande(commandeFournisseur.getDateCommande())
                .fournisseur(commandeFournisseur.getFournisseur())
                .build();
    }

    public CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto){
        if(commandeFournisseurDto == null)
            return null;

        return CommandeFournisseur.builder()
                .id(commandeFournisseurDto.getId())
                .code(commandeFournisseurDto.getCode())
                .dateCommande(commandeFournisseurDto.getDateCommande())
                .fournisseur(commandeFournisseurDto.getFournisseur())
                .build();
    }
}
