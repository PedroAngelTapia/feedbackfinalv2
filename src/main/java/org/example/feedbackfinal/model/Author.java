package org.example.feedbackfinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Entity
@Data
public class Author {

    /** Clave primaria generada automáticamente */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nombre del autor */
    private String name;

    /** Campo 'x' (red social X/Twitter) */
    private String x;

    /** Enlace a YouTube si existe */
    private String youtube;

    /** Enlace a Instagram si exista */
    private String instagram;

    /** Enlace a LinkedIn si existe */
    private String linkedin;

    /** Enlace a Mastodon si existe */
    private String mastodon;

    /** Enlace a Bluesky si existe */
    private String bluesky;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;
}
