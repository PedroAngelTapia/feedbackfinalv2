package org.example.FeedBackFinalApplication.controller;

import org.example.FeedBackFinalApplication.model.Article;
import org.example.FeedBackFinalApplication.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArticleController {

    private final ArticleService service;

    public ArticleController(ArticleService service) {
        this.service = service;
    }

    /**
     * Ruta raíz (“/”):
     * - Llama al servicio para obtener y guardar las noticias
     * - Mete la lista en el Model para Thymeleaf
     * - Devuelve la plantilla “index”
     */
    @GetMapping("/")
    public String index(Model model) {
        List<Article> articles = service.fetchAndSaveAll();
        model.addAttribute("articles", articles);
        return "index";
    }
}
