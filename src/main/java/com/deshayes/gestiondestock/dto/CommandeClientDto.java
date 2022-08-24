package com.deshayes.gestiondestock.dto;

import com.deshayes.gestiondestock.model.Client;
import com.deshayes.gestiondestock.model.CommandeClient;
import com.deshayes.gestiondestock.model.LigneCommandeClient;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class CommandeClientDto {

    private Integer id;

    private String code;

    private Instant date;

    private Client client;

    @JsonIgnore
    private List<LigneCommandeClient> ligneCommandeClients;

    public CommandeClientDto fromEntity(CommandeClient commandeClient){
        if(commandeClient == null)
            return null;

        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .date(commandeClient.getDate())
                .client(commandeClient.getClient())
                .build();
    }

    public CommandeClient toEntity(CommandeClientDto commandeClientDto){
        if(commandeClientDto == null)
            return null;

        return CommandeClient.builder()
                .id(commandeClientDto.id)
                .code(commandeClientDto.code)
                .date(commandeClientDto.date)
                .client(commandeClientDto.client)
                .build();
    }
}
