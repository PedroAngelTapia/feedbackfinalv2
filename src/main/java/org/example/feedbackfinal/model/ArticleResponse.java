package org.example.feedbackfinal.model;

import lombok.Data;

import java.util.List;


@Data
public class ArticleResponse {
    /** Número total de resultados */
    private int count;

    /** URL para la siguiente página de resultados */
    private String next;

    /** URL para la página anterior (null si no hay) */
    private String previous;

    /** Lista de objetos Article mapeados directamente desde JSON */
    private List<Article> results;
}
