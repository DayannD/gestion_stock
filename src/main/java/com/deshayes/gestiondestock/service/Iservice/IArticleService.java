package com.deshayes.gestiondestock.service.Iservice;

import com.deshayes.gestiondestock.dto.ArticleDto;

import java.util.List;

public interface IArticleService {

    public ArticleDto save(ArticleDto articleDto);
    public ArticleDto findById(Integer id);
    public ArticleDto findByCode(String code);
    public List<ArticleDto> findAll();
    public void delete(Integer id);
}
