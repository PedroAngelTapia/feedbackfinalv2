package org.example.FeedBackFinalApplication.service;

import org.example.FeedBackFinalApplication.model.Article;
import org.example.FeedBackFinalApplication.model.ArticleResponse;
import org.example.FeedBackFinalApplication.repository.ArticleRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ArticleService {

    // URL base del API de Spaceflight News
    private static final String API_URL = "https://api.spaceflightnewsapi.net/v4/articles/";

    private final RestTemplate restTemplate;
    private final ArticleRepository repo;

    public ArticleService(RestTemplate restTemplate, ArticleRepository repo) {
        this.restTemplate = restTemplate;
        this.repo = repo;
    }

    /**
     * 1) Llama al API y obtiene JSON -> ArticleResponse
     * 2) Extrae lista de Article
     * 3) Persiste en H2 (cascade guarda también autores)
     * 4) Devuelve lista para el controlador
     */
    public List<Article> fetchAndSaveAll() {
        ArticleResponse resp = restTemplate.getForObject(API_URL, ArticleResponse.class);
        List<Article> list = resp.getResults();
        repo.saveAll(list);
        return list;
    }

    /** Devuelve todos los artículos actuales en la BD */
    public List<Article> getAll() {
        return repo.findAll();
    }
}
