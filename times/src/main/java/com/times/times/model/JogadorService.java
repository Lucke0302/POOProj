/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.times.times.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Work
 */

@Service
public class JogadorService {

    @Autowired
    private JogadorDAO dao;

    public void inserirJogador(Jogador jogador) {
        dao.inserirJogador(jogador);
    }

    public List<Jogador> puxarTodosArtistas() {
        List<Map<String, Object>> registros = dao.selectJogadoresCorinthians1();
        return Jogador.converterVarios(registros);
    }
    /*
    public Artista puxarArtista(int id) {
        Map<String, Object> registro = dao.puxarArtista(id);
        return Artista.converter(registro);
    }

    public void atualizarArtista(int id, Artista artista) {
        dao.atualizarArtista(id, artista);
    }

    public void deletar(int id) {
        dao.deletar(id);
    }

    public List<Artista> buscarPorEstilo(String estilo) {
        List<Map<String, Object>> registros = dao.buscarPorEstilo(estilo);
        return Artista.converterVarios(registros);
    }
    }*/

}
