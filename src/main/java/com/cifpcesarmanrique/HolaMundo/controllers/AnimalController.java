package com.cifpcesarmanrique.HolaMundo.controllers;

import com.cifpcesarmanrique.HolaMundo.models.Animal;
import com.cifpcesarmanrique.HolaMundo.services.AnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService service;

    public AnimalController(AnimalService service) {
        this.service = service;
    }
    //listado
    @GetMapping
    public String index(Model model) {
        model.addAttribute("animals", service.findAll());
        return "animals/index";
    }

    //detalle
    @GetMapping("{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Animal animal = service.findById(id);
        if (animal == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Animal no encontrado");
        }
        model.addAttribute("animal", animal);
        return "animals/detail";
    }

    //formulario de creación get
    @GetMapping("/new")
    public String crearFormulario(Model model)
    {
        model.addAttribute("animal", new Animal());
        return "animals/crearAnimales";
    }

    //recibir datos del formulario
    @PostMapping
    public String save(@Validated @ModelAttribute("animal") Animal animal, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            return "animals/crearAnimales";
        }
        service.save(animal);
        return "redirect:/animals";
    }

    //recibir cambios del formulario
    @GetMapping("{id}/edit")
    public String editar(@PathVariable Integer id, Model model)
    {
        Animal animal = service.findById(id);
        if (animal == null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Animal no encontrado");
        }
        model.addAttribute("animal",animal);
        return "animals/crearAnimales";
    }

    // muestra la página HTML de confirmación antes de borrar
    @GetMapping("{id}/delete")
    public String confirmarEliminar(@PathVariable Integer id, Model model) {
        Animal animal = service.findById(id);
        if (animal == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Animal no encontrado");
        }
        model.addAttribute("animal", animal);
        return "animals/eliminarAnimal";
    }

    // borra el animal definitivamente
    @PostMapping("{id}/delete")
    public String ejecutarEliminar(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/animals";
    }

}