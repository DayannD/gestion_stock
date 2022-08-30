package com.deshayes.gestiondestock.service.Iservice;

import com.deshayes.gestiondestock.dto.ArticleDto;
import com.deshayes.gestiondestock.dto.CategoryDto;

import java.util.List;

public interface ICategoryService {

    CategoryDto save(CategoryDto categoryDto);

    CategoryDto findById(Integer id);

    CategoryDto findByCode(String code);

    List<CategoryDto> findAll();

    void delete(Integer id);
}
