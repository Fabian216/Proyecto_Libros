package com.front.front.controllers;



import com.front.front.models.Libro;
import com.front.front.services.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LibroController {

    private ILibroService libro;

    @Autowired
    public LibroController(ILibroService libro) {
        this.libro = libro;
    }

    @GetMapping("/listalibros")
    public String getAll(Model model){
        List<Libro> lista = this.libro.getAll();
        model.addAttribute("getAllLibros",lista);
        return "listalibros";
    }

    @PostMapping("/crearlibros")
    public String create(@ModelAttribute Libro entity, Model model){
        Libro obj = this.libro.create(entity);
        model.addAttribute("createlibro",obj);
        return "redirect:/listalibros";
    }

    @GetMapping("/crearlibros")
    public String formLibro(Model model){
        model.addAttribute("formlibro", new Libro());
        return "nuevolibro";
    }


}
