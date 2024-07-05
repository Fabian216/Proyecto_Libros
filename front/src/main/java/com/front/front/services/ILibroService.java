package com.front.front.services;

import com.front.front.models.Libro;

import java.util.List;

public interface ILibroService {
    List<Libro> getAll();
    Libro create(Libro entity);
}
