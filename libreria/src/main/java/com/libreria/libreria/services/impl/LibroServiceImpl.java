package com.libreria.libreria.services.impl;

import com.libreria.libreria.models.Libro;
import com.libreria.libreria.repository.ILibroRepository;
import com.libreria.libreria.services.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LibroServiceImpl implements ILibroService {

    private ILibroRepository repository;

    @Autowired
    public LibroServiceImpl(ILibroRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Libro> getAll(){
        return this.repository.findAll();
    }

    @Override
    public Libro findById(int id){
        return this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"libro no encontrado"));
    }

    @Override
    public Libro create(Libro entity){
        return this.repository.save(entity);
    }

    @Override
    public Libro update(int id, Libro libro){

        Libro nuevo_libro = this.findById(id);

        nuevo_libro.setTitulo(libro.getTitulo());
        nuevo_libro.setAutor(libro.getAutor());
        nuevo_libro.setGenero(libro.getGenero());
        nuevo_libro.setEstado(libro.getEstado());
        return this.repository.save(nuevo_libro);
    }

    @Override
    public void delete(int id){
        var obj = this.findById(id);

        this.repository.delete(obj);
    }

}
