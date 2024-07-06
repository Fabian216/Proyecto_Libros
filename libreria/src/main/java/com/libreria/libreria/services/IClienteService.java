package com.libreria.libreria.services;

import com.libreria.libreria.models.Cliente;

import java.util.List;

public interface IClienteService {
    List<Cliente> getAll();
    Cliente findById(int id);
    Cliente create(Cliente entity);
    Cliente update(int id,Cliente entity);
    void delete(int id);
}
