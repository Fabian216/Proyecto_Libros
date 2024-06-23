package org.example.simple.models;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "Libro")
@data
@NoArgsConstructor

public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "autor")
    private String autor;

    @Column(name = "genero")
    private String genero;

    @Column(name = "lanzamiento")
    private Date lanzamiento;

    @Column(name = "estado")
    private String estado;

}
