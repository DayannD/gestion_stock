package com.deshayes.gestiondestock.service.Iservice;

import com.deshayes.gestiondestock.dto.ArticleDto;

import java.util.List;

public interface IArticleService {

    ArticleDto save(ArticleDto articleDto);
    ArticleDto findById(Integer id);
    ArticleDto findByCode(String code);
    List<ArticleDto> findAll();
    void delete(Integer id);
}
