package com.deshayes.gestiondestock.service;

import com.deshayes.gestiondestock.dto.CategoryDto;
import com.deshayes.gestiondestock.exception.EntityNotFoundException;
import com.deshayes.gestiondestock.exception.ErrorCodes;
import com.deshayes.gestiondestock.exception.InvalideEntityException;
import com.deshayes.gestiondestock.model.Article;
import com.deshayes.gestiondestock.model.Category;
import com.deshayes.gestiondestock.repository.CategoryRepository;
import com.deshayes.gestiondestock.service.Iservice.ICategoryService;
import com.deshayes.gestiondestock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        List<String> errors = CategoryValidator.validate(categoryDto);

        if (!errors.isEmpty()){
            log.error("il y a des erreurs de category",categoryDto);
            throw new InvalideEntityException("Probleme",ErrorCodes.CATEGORY_NOT_VALID,errors );
        }

        return CategoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(categoryDto)));
    }

    @Override
    public CategoryDto findById(Integer id) {
        if(id == null){
            log.error("id is null");
            return null;
        }
        Optional<Category> category = categoryRepository.findById(id);
        CategoryDto categoryDto = CategoryDto.fromEntity(category.get());
        return Optional.of(categoryDto).orElseThrow(() ->
                        new EntityNotFoundException(
                                "la category avec l'ic" + id + "na pas était trouver",
                                ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public CategoryDto findByCode(String code) {
        if(code == null){
            log.error("code is null");
            return null;
        }
        Optional<Category> category = categoryRepository.findCategoriesByCode(code);
        CategoryDto categoryDto = CategoryDto.fromEntity(category.get());
        return Optional.of(categoryDto).orElseThrow(() ->
                new EntityNotFoundException(
                        "la category avec lle code" + code + "na pas était trouver",
                        ErrorCodes.CATEGORY_NOT_FOUND));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("L'id est null");
            return;
        }

        categoryRepository.deleteById(id);
    }
}
