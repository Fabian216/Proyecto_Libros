package com.front.front.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String genero;
    private String estado;
}
