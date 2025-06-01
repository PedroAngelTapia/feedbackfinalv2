package org.example.feedbackfinal.controller;

import org.example.feedbackfinal.model.Article;
import org.example.feedbackfinal.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class ArticleController {

    private final ArticleService articleService;


    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @GetMapping("/")
    public String index(Model model) {
        // Llamamos al servicio para que descargue desde la API y se guarde en H2
        List<Article> articulos = articleService.fetchAndSaveAll();

        // Añadimos la lista de artículos al modelo con la clave "articles"
        model.addAttribute("articles", articulos);

        // Retornamos el nombre de la plantilla (index.html)
        return "index";
    }
}

