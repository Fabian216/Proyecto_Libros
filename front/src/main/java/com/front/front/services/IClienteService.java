package com.front.front.services;

import com.front.front.models.Cliente;

import java.util.List;

public interface IClienteService {
    List<Cliente> getAll();
    Cliente create(Cliente entity);
}
