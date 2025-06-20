/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.times.times.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;


@Repository
public class JogadorDAO {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserirJogador(Jogador jogador) {
        String sql = "INSERT INTO jogadores(nome, dataNasc, timeJogador, altura, peso, camisa, gols, assists) VALUES(?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?, ?, ?, ?)";
        Object[] parametros = new Object[8];
        parametros[0] = jogador.getNome();
        parametros[1] = jogador.getDataNasc();
        parametros[2] = jogador.getTimeJogador();
        parametros[3] = jogador.getAltura();
        parametros[4] = jogador.getPeso();
        parametros[5] = jogador.getCamisa();
        parametros[6] = jogador.getGols();
        parametros[7] = jogador.getAssists();
        jdbc.update(sql, parametros);
    }

    public List<Map<String, Object>> selectJogadoresCorinthians1() {
        String sql = "SELECT * FROM jogadores WHERE timejogador = 'CORINTHIANS' ORDER BY camisa LIMIT 12";
        return jdbc.queryForList(sql);
    }

    public List<Map<String, Object>> selectJogadoresCorinthians2() {
        String sql = "SELECT * FROM jogadores WHERE timejogador = 'CORINTHIANS' ORDER BY camisa LIMIT 12 OFFSET 12";
        return jdbc.queryForList(sql);
    }

    public List<Map<String, Object>> selectJogadoresCorinthians3() {
        String sql = "SELECT * FROM jogadores WHERE timejogador = 'CORINTHIANS' ORDER BY camisa LIMIT 12 OFFSET 24";
        return jdbc.queryForList(sql);
    }

    public List<Map<String, Object>> selectJogadoresSantos1() {
        String sql = "SELECT * FROM jogadores WHERE timejogador = 'SANTOS' ORDER BY camisa LIMIT 12";
        return jdbc.queryForList(sql);
    }

    public List<Map<String, Object>> selectJogadoresSantos2() {
        String sql = "SELECT * FROM jogadores WHERE timejogador = 'SANTOS' ORDER BY camisa LIMIT 12 OFFSET 12";
        return jdbc.queryForList(sql);
    }

    public List<Map<String, Object>> selectJogadoresSantos3() {
        String sql = "SELECT * FROM jogadores WHERE timejogador = 'SANTOS' ORDER BY camisa LIMIT 12 OFFSET 24";
        return jdbc.queryForList(sql);
    }

    /*    
    public void atualizarArtista(int id, Artista novo) {
        String sql = "UPDATE artistas SET nome = ?, estilo = ? WHERE id = ?";
        Object[] parametros = new Object[3];
        parametros[0] = novo.getNome();
        parametros[1] = novo.getEstilo();
        parametros[2] = id;
        jdbc.update(sql, parametros);
    }

    public void deletar(int id) {
        String sql = "DELETE FROM artistas WHERE id = ?";
        jdbc.update(sql, id);
    }

        public List<Map<String, Object>> buscarPorEstilo(String estilo) {
        String sql = "SELECT * FROM artistas WHERE estilo ILIKE ? ORDER BY id";
        Object[] parametros = new Object[] { "%" + estilo + "%" };
        return jdbc.queryForList(sql, parametros);
    }
    */
}
