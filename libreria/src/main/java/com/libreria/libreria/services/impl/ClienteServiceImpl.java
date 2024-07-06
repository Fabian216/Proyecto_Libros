package com.libreria.libreria.services.impl;

import com.libreria.libreria.models.Cliente;
import com.libreria.libreria.repository.IClienteRepository;
import com.libreria.libreria.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    private IClienteRepository repository;

    @Autowired
    public ClienteServiceImpl(IClienteRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Cliente> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Cliente findById(int id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Cliente no encontrado"
                ));
    }

    @Override
    public Cliente create(Cliente entity) {
        return this.repository.save(entity);
    }

    @Override
    public Cliente update(int id, Cliente cliente) {

        Cliente bd_cliente = this.findById(id);

        bd_cliente.setDni(cliente.getDni());
        bd_cliente.setNombre(cliente.getNombre());
        bd_cliente.setEmail(cliente.getEmail());
        bd_cliente.setTelefono(cliente.getTelefono());
        return this.repository.save(bd_cliente);
    }

    @Override
    public void delete(int id) {
        var obj = this.findById(id);
        this.repository.delete(obj);
    }
}
