package org.example.feedbackfinal.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class Article {


    @Id
    private int id;

    /** Título de la noticia */
    private String title;

    /** Enlace a la noticia original */
    private String url;

    /** URL de la imagen asociada a la noticia */
    private String image_url;

    /**
     * Resumen de la noticia. */
    @Column(length = 20000)
    private String summary;

    /**
     * Relación uno-a-muchos con Author.*/

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Author> authors = new ArrayList<>();
}
