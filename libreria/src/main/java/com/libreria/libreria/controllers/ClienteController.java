package com.libreria.libreria.controllers;


import com.libreria.libreria.models.Cliente;
import com.libreria.libreria.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private IClienteService cliente;

    @Autowired
    public ClienteController(IClienteService cliente) {
        this.cliente = cliente;
    }

    @GetMapping
    public List<Cliente> getAll(){
        return this.cliente.getAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable int id){
        return this.cliente.findById(id);
    }

    @GetMapping
    public Cliente create(@RequestBody Cliente nuevo_cliente){
        return this.cliente.create(nuevo_cliente);
    }

    @GetMapping("/{id}")
    public Cliente update(@PathVariable int id,
                          @RequestBody Cliente cliente_actualizado){
        return this.cliente.update(id,cliente_actualizado);
    }

    @GetMapping("/{id}")
    public void delete(@PathVariable int id){
        this.cliente.delete(id);
    }


}
