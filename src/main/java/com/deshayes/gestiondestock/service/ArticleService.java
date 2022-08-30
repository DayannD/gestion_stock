package com.deshayes.gestiondestock.service;

import com.deshayes.gestiondestock.dto.ArticleDto;
import com.deshayes.gestiondestock.exception.EntityNotFoundException;
import com.deshayes.gestiondestock.exception.ErrorCodes;
import com.deshayes.gestiondestock.exception.InvalideEntityException;
import com.deshayes.gestiondestock.model.Article;
import com.deshayes.gestiondestock.repository.ArticleRepository;
import com.deshayes.gestiondestock.service.Iservice.IArticleService;
import com.deshayes.gestiondestock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class ArticleService implements IArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto);

        if(!errors.isEmpty()){
            log.error("Article is not valid",articleDto);
            throw new InvalideEntityException("L'article n'est pas valide", ErrorCodes.ARTICLES_NOT_VALID,errors);
        }

        return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(articleDto)));
    }

    @Override
    public ArticleDto findById(Integer id) {
        if (id == null){
            log.error("article ID is null");
            return null;
        }
        Optional<Article> article = articleRepository.findById(id);

        ArticleDto articleDto = ArticleDto.fromEntity(article.get());

        return Optional.of(articleDto).orElseThrow(() ->
                new EntityNotFoundException(
                        "cette article n'as pas était trouvé dans la bdd",
                        ErrorCodes.ARTICLES_NOT_FOUND)
        );
    }

    @Override
    public ArticleDto findByCode(String code) {
        if (code == null){
            log.error("article code is null");
            return null;
        }
        Optional<Article> article = articleRepository.findByCodeArticle(code);

        ArticleDto articleDto = ArticleDto.fromEntity(article.get());

        return Optional.of(articleDto).orElseThrow(() ->
                new EntityNotFoundException(
                        "ce code article n'as pas était trouvé dans la bdd",
                        ErrorCodes.ARTICLES_NOT_FOUND)
        );
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("article ID is null");
            return;
        }
        articleRepository.deleteById(id);
    }
}
