package com.libreria.libreria.repository;

import com.libreria.libreria.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibroRepository extends JpaRepository<Libro, Integer>{
}
