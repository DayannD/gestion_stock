package com.deshayes.gestiondestock.repository;

import com.deshayes.gestiondestock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Integer, Article> {


}
