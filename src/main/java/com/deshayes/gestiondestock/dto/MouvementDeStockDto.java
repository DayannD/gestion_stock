package com.deshayes.gestiondestock.dto;

import com.deshayes.gestiondestock.model.Article;
import com.deshayes.gestiondestock.model.MouvementDeStock;
import com.deshayes.gestiondestock.model.TypeMvtStk;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MouvementDeStockDto {

    private Integer id;

    private Instant dateMvt;

    private BigDecimal quantite;

    private Article article;

    private TypeMvtStk typeMvt;


    public MouvementDeStockDto fromEntity(MouvementDeStock mouvementDeStock){
        if (mouvementDeStock == null)
            return null;

        return MouvementDeStockDto.builder()
                .id(mouvementDeStock.getId())
                .dateMvt(mouvementDeStock.getDateMvt())
                .quantite(mouvementDeStock.getQuantite())
                .article(mouvementDeStock.getArticle())
                .typeMvt(mouvementDeStock.getTypeMvt())
                .build();
    }

    public MouvementDeStock toEntity(MouvementDeStockDto mouvementDeStockDto){
        if (mouvementDeStockDto == null)
            return null;

        return MouvementDeStock.builder()
                .id(mouvementDeStockDto.getId())
                .dateMvt(mouvementDeStockDto.getDateMvt())
                .quantite(mouvementDeStockDto.getQuantite())
                .article(mouvementDeStockDto.getArticle())
                .typeMvt(mouvementDeStockDto.getTypeMvt())
                .build();
    }
}
