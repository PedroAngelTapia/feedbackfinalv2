package org.example.FeedBackFinalApplication.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;           // PK autogenerado

    private String name;       // Nombre del autor
    private String x;          // Twitter (campo "x")
    private String youtube;
    private String instagram;
    private String linkedin;
    private String mastodon;
    private String bluesky;

    /** Cada autor “pertenece” a un artículo */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;
}
