package com.deshayes.gestiondestock.dto;

import com.deshayes.gestiondestock.model.Ventes;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.time.Instant;

@Data
@Builder
public class VentesDto {

    private Integer id;

    private String code;

    private Instant dateVente;

    private String commentaire;


    public VentesDto fromEntity(Ventes ventes){
        if (ventes == null)
            return null;

        return VentesDto.builder()
                .id(ventes.getId())
                .code(ventes.getCode())
                .dateVente(ventes.getDateVente())
                .commentaire(ventes.getCommentaire())
                .build();
    }

    public Ventes toEntity(VentesDto ventesDto){
        if (ventesDto == null)
            return null;

        return Ventes.builder()
                .id(ventesDto.getId())
                .code(ventesDto.getCode())
                .dateVente(ventesDto.getDateVente())
                .commentaire(ventesDto.getCommentaire())
                .build();
    }
}
