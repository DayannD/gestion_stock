package com.deshayes.gestiondestock.dto;

import com.deshayes.gestiondestock.model.Article;
import com.deshayes.gestiondestock.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDto {

    private Integer id;

    private String code;

    private String designation;

    @JsonIgnore
    private List<Article> articles;

    public static CategoryDto fromEntity(Category category){
        if(category == null){
            // TODO: 24/08/2022 throw an exception
            return null;
        }

        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .build();
    }

    public static Category toEntity(CategoryDto categoryDto){
        if(categoryDto == null){
            return null;
        }

        return Category.builder()
                .id(categoryDto.getId())
                .code(categoryDto.getCode())
                .designation(categoryDto.getDesignation())
                .build();
    }
}
