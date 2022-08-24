package com.deshayes.gestiondestock.dto;

import com.deshayes.gestiondestock.model.Roles;
import com.deshayes.gestiondestock.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Builder
public class RolesDto {

    private Integer id;

    private String roleName;

    private Utilisateur utilisateur;


    public RolesDto fromEntity(Roles roles){
        if (roles == null)
            return null;

        return RolesDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .utilisateur(roles.getUtilisateur())
                .build();
    }

    public RolesDto toEntity(Roles roles){
        if (roles == null)
            return null;

        return RolesDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .utilisateur(roles.getUtilisateur())
                .build();
    }
}
