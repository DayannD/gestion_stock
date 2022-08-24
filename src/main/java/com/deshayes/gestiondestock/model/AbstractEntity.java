package com.deshayes.gestiondestock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)

//AuditingEntityListener fournit par spring va automatiquement mettre a jour nos champ lors de la création et modification
public class AbstractEntity implements Serializable {
    //Création d'une class Abstrac afin de généraliser le code (éviter les redondances)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @CreatedDate //Date de création du champ
    @Column(name = "creationDate", nullable = false,insertable = false,updatable = false)// nom attribute dans la bdd
    @JsonIgnore // n'apparaîtra pas dans l'objet JSON lors de la sérialisation
    private Instant creationDate;

    @LastModifiedDate
    @Column(name = "creationDate")
    @JsonIgnore
    private Instant lastUpdateDate;
}
