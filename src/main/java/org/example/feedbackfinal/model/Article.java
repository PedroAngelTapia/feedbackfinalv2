package org.example.FeedBackFinalApplication.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Article {

    /** ID que devuelve el API (no generado) */
    @Id
    private int id;

    private String title;           // Título de la noticia
    private String url;             // Enlace original
    private String image_url;       // URL de la imagen

    @Column(length = 20000)
    private String summary;         // Resumen

    /** Relación uno-a-muchos con autores */
    @OneToMany(mappedBy = "article",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Author> authors = new ArrayList<>();
}
