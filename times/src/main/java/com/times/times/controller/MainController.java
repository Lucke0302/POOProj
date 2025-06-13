package com.times.times.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @Autowired
    ApplicationContext ctx;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    /*@GetMapping("/formulario")
    public String formulario(Model model) {
        model.addAttribute("artista", new Artista());
        model.addAttribute("titulo", "CADASTRO DE ARTISTAS");
        model.addAttribute("link", "/cadastro");
        model.addAttribute("valor", "Cadastrar");
        return "formulario";
    } @PostMapping("/cadastro")
    public String cadastro(@ModelAttribute Artista artista) {
        ArtistaService as = ctx.getBean(ArtistaService.class);
        as.inserirArtista(artista);
        return "index";
    }
    @PostMapping("/editar/{id}")
    public String editarSalvar(@PathVariable int id, @ModelAttribute Artista artista) {
        ArtistaService as = ctx.getBean(ArtistaService.class);
        as.atualizarArtista(id, artista);
        return "redirect:/listar";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable int id) {
        ArtistaService as = ctx.getBean(ArtistaService.class);
        as.deletar(id);
        return "redirect:/listar";
    }*/
}