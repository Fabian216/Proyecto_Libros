package com.front.front.services.impl;

import com.front.front.models.Cliente;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;

@Service
public class IClienteService implements com.front.front.services.IClienteService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Cliente> getAll(){
        String url = "http://localhost:8080/clientes";
        Cliente[] obj = restTemplate.getForObject(url,Cliente[].class);
        return Arrays.asList(obj);
    }

    @Override
    public Cliente create(Cliente entity) {
        String url = "http://localhost:8080/clientes";
        return restTemplate.postForObject(url,entity,Cliente.class);
    }


}
