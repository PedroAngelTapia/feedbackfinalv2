package org.example.feedbackfinal.repository;

import org.example.feedbackfinal.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    // No se necesita añadir más métodos básicos: findAll, findById, saveAll, save, delete, etc.
}
