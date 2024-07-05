package com.front.front.services.impl;


import com.front.front.models.Cliente;
import com.front.front.services.IClienteService;
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
    public Cliente create(Cliente entity) {
        String url = "http://localhost:8080/clientes";
        return this.restTemplate.postForObject(url,entity,Cliente.class);
    }


}
