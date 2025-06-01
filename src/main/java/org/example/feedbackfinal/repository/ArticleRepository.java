package org.example.FeedBackFinalApplication.repository;

import org.example.FeedBackFinalApplication.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    // findAll(), saveAll(), deleteAll(), etc. ya disponibles
}
