package com.front.front.controllers;

import com.front.front.models.Cliente;
import com.front.front.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class ClienteController {

    private IClienteService cliente;

    @Autowired
    public ClienteController(IClienteService cliente) {
        this.cliente = cliente;
    }

    @GetMapping("/listaclientes")
    public String getAll(Model model){
        List<Cliente> lista = this.cliente.getAll();
        model.addAttribute("getAllClientes",lista);
        return "clientesvista";
    }

    @PostMapping("/crearcliente")
    public String create(@ModelAttribute Cliente entity,Model model){
        Cliente obj = this.cliente.create(entity);
        model.addAttribute("createCliente",obj);
        return "redirect:/listaclientes";
    }

    @GetMapping("/crearcliente")
    public String formCliente(Model model){
        model.addAttribute("formcliente", new Cliente());
        return "nuevocliente";
    }

}
