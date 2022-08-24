package com.deshayes.gestiondestock.dto;

import com.deshayes.gestiondestock.model.Adresse;
import com.deshayes.gestiondestock.model.Client;
import com.deshayes.gestiondestock.model.CommandeClient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
public class ClientDto {

    private Integer id;

    private String name;

    private String prenom;

    private Adresse adresse;

    private String photo;

    private String email;

    private String tel;

    @JsonIgnore
    private List<CommandeClient> commandeClient;

    public ClientDto fromEntity(Client client){
        if(client == null){
            return null;
        }

        return ClientDto.builder()
                .id(client.getId())
                .name(client.getName())
                .prenom(client.getPrenom())
                .adresse(client.getAdresse())
                .photo(client.getPhoto())
                .email(client.getEmail())
                .tel(client.getTel())
                .build();
    }

    public Client toEntity(ClientDto clientDto){
        if(clientDto == null)
            return null;

        return Client.builder()
                .id(clientDto.id)
                .name(clientDto.getName())
                .prenom(clientDto.prenom)
                .adresse(clientDto.getAdresse())
                .photo(clientDto.getPhoto())
                .email(clientDto.email)
                .tel(clientDto.getTel())
                .build();
    }
}
