package com.deshayes.gestiondestock.repository;

import com.deshayes.gestiondestock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    Optional<Article> findByCodeArticle(String codeArticle);

}
