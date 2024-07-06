package com.front.front.services.impl;



import com.front.front.models.Libro;
import com.front.front.services.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class LibroServiceImpl implements ILibroService {

    private RestTemplate restTemplate;

    @Autowired
    public LibroServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public List<Libro> getAll(){
        String url = "http://localhost:8080/libros";
        Libro[] obj = this.restTemplate.getForObject(url,Libro[].class);
        return Arrays.asList(obj);
    }

    @Override
    public Libro create(Libro entity){
        String url = "http://localhost:8080/libros";
        return this.restTemplate.postForObject(url,entity,Libro.class);
    }

    @Override
    public Libro findById(int id) {
        String url = "http://localhost:8080/libros/" + id;
        return this.restTemplate.getForObject(url, Libro.class);
    }

    @Override
    public Libro update(int id, Libro entity) {
        String url = "http://localhost:8080/libros/" + id;
        HttpEntity<Libro> requestUpdate = new HttpEntity<>(entity);
        ResponseEntity<Libro> response = this.restTemplate.exchange(url, HttpMethod.PUT, requestUpdate, Libro.class);
        return response.getBody();
    }

    @Override
    public void delete(int id) {
        String url = "http://localhost:8080/libros/" + id;
        this.restTemplate.delete(url);
    }


}
