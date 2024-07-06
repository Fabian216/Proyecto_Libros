package com.front.front.controllers;




import com.front.front.models.Libro;
import com.front.front.services.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/libro/{id}")
    public String getLibroById(@PathVariable int id, Model model) {
        Libro libro = this.libro.findById(id);
        model.addAttribute("libro", libro);
        return "detallelibro";
    }


    @PostMapping("/libro/editar/{id}")
    public String updateLibro(@PathVariable int id, @ModelAttribute Libro libro, Model model) {
        Libro updatedLibro = this.libro.update(id, libro);
        model.addAttribute("updateLibro", updatedLibro);
        return "redirect:/listalibros";
    }



    @GetMapping("/libro/eliminar/{id}")
    public String deleteLibro(@PathVariable int id) {
        this.libro.delete(id);
        return "redirect:/listalibros";
    }

}
