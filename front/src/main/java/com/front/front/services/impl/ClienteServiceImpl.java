package com.front.front.services.impl;


import com.front.front.models.Cliente;
import com.front.front.services.IClienteService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    private RestTemplate restTemplate;

    @Autowired
    public ClienteServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Cliente> getAll(){
        String url = "http://localhost:8080/clientes";
        Cliente[] obj = this.restTemplate.getForObject(url,Cliente[].class);
        return Arrays.asList(obj);
    }

    @Override
    public Cliente findById(int id) {
        String url = "http://localhost:8080/clientes/" + id;
        return this.restTemplate.getForObject(url, Cliente.class);
    }

    @Override
    public Cliente create(Cliente entity) {
        String url = "http://localhost:8080/clientes";
        return this.restTemplate.postForObject(url,entity,Cliente.class);
    }

    @Override
    public Cliente update(int id, Cliente entity) {
        String url = "http://localhost:8080/clientes/" + id;
        HttpEntity<Cliente> requestUpdate = new HttpEntity<>(entity);
        ResponseEntity<Cliente> response = this.restTemplate.exchange(url, HttpMethod.PUT, requestUpdate, Cliente.class);
        return response.getBody();
    }

    @Override
    public void delete(int id) {
        String url = "http://localhost:8080/clientes/" + id;
        this.restTemplate.delete(url);
    }


}
