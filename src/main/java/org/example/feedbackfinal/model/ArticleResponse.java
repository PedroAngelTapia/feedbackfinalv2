package org.example.FeedBackFinalApplication.model;

import lombok.Data;
import java.util.List;

@Data
public class ArticleResponse {
    private int count;               // Total de resultados
    private String next;             // URL siguiente página
    private String previous;         // URL previa página
    private List<Article> results;   // Lista de Article mapeados
}
