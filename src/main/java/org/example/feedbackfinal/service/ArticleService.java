package org.example.feedbackfinal.service;

import org.example.feedbackfinal.model.Article;
import org.example.feedbackfinal.model.ArticleResponse;
import org.example.feedbackfinal.repository.ArticleRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Capa de servicio (business logic) que se encarga de:
 *  1) Llamar al API externo de Spaceflight News para obtener JSON de artículos.
 *  2) Mapear ese JSON a ArticleResponse → List<Article>.
 *  3) Persistir automáticamente los artículos (y sus autores) en H2 vía ArticleRepository.
 *  4) Devolver la lista de artículos para que el controlador la use en la vista.
 */
@Service
public class ArticleService {

    /** URL base del API de Spaceflight News */
    private static final String API_URL = "https://api.spaceflightnewsapi.net/v4/articles/";

    private final RestTemplate restTemplate;
    private final ArticleRepository articleRepository;

    /**
     * Inyectamos RestTemplate y ArticleRepository mediante constructor.
     * Spring buscará el bean RestTemplate (definido en RestConfig) y el
     * bean ArticleRepository (generado automáticamente por Spring Data).
     */
    public ArticleService(RestTemplate restTemplate, ArticleRepository articleRepository) {
        this.restTemplate = restTemplate;
        this.articleRepository = articleRepository;
    }

    /**
     * 1. Llama al API (GET https://.../articles/) y Jackson mapea la respuesta a ArticleResponse.
     * 2. Extrae la lista de Article (resp.getResults()).
     * 3. Persiste en BD (articleRepository.saveAll(...)). El cascade de Article → Author guarda también los autores.
     * 4. Devuelve la lista para el controlador.
     *
     * @return Lista de artículos recién obtenidos y guardados en H2.
     */
    public List<Article> fetchAndSaveAll() {
        // Hace la petición HTTP GET y convierte JSON a ArticleResponse
        ArticleResponse resp = restTemplate.getForObject(API_URL, ArticleResponse.class);

        // Si por alguna razón resp es null, retornamos lista vacía
        if (resp == null || resp.getResults() == null) {
            return List.of();
        }

        // Obtenemos la lista de artículos
        List<Article> articles = resp.getResults();

        // Guardamos en H2: Article + cada Author (gracias a CascadeType.ALL)
        articleRepository.saveAll(articles);

        return articles;
    }

    /**
     * Devuelve todos los artículos que ya estén en la BD (H2).
     * Puede usarse si queremos mostrar solo lo que hay sin volver a llamar al API.
     *
     * @return Lista completa de Article almacenados.
     */
    public List<Article> getAll() {
        return articleRepository.findAll();
    }
}
