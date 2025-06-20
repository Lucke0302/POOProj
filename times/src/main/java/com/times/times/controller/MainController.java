package com.times.times.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.times.times.model.Jogador;
import com.times.times.model.JogadorDAO;
import com.times.times.model.JogadorService;


@Controller
public class MainController {

    @Autowired
    ApplicationContext ctx;
    @Autowired
    private JogadorDAO jogador;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/cadastroJogador")
    public String cadastroJogador(Model model) {
        model.addAttribute("jogador", new Jogador());
        model.addAttribute("titulo", "Cadastro de jogador");
        model.addAttribute("link", "/cadastro");
        model.addAttribute("valor", "Cadastrar");
        return "cadastroJogador"; 
    } 
    @PostMapping("/cadastro")
    public String cadastro(@ModelAttribute Jogador jogador) {
        JogadorService as = ctx.getBean(JogadorService.class);
        as.inserirJogador(jogador);
        return "index";
    }

    @GetMapping("/jogadores")
    public String exibirJogadores(Model model) {
        List<Map<String, Object>> CorinthiansCol1 = jogador.selectJogadoresCorinthians1();
        List<Map<String, Object>> CorinthiansCol2 = jogador.selectJogadoresCorinthians2();
        List<Map<String, Object>> CorinthiansCol3 = jogador.selectJogadoresCorinthians3();

        model.addAttribute("corinthiansCol1", CorinthiansCol1);
        model.addAttribute("corinthiansCol2", CorinthiansCol2);
        model.addAttribute("corinthiansCol3", CorinthiansCol3);

        List<Map<String, Object>> SantosCol1 = jogador.selectJogadoresSantos1();
        List<Map<String, Object>> SantosCol2 = jogador.selectJogadoresSantos2();
        List<Map<String, Object>> SantosCol3 = jogador.selectJogadoresSantos3();

        model.addAttribute("santosCol1", SantosCol1);
        model.addAttribute("santosCol2", SantosCol2);
        model.addAttribute("santosCol3", SantosCol3);

        return "jogadores";
    }
    /*@PostMapping("/editar/{id}")
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