/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.times.times.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Work
 */
public class Jogador {

    private String nome, dataNasc, camisa, timeJogador;
    private int altura, gols, assists, id;
    private float peso;

    public Jogador(){}

    public Jogador(String nome, String dataNasc, String camisa, String timeJogador, float peso, int altura, int gols, int assists){
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.camisa = camisa;
        this.timeJogador = timeJogador;        
        this.peso = peso;
        this.altura = altura;
        this.gols = gols;
        this.assists = assists;
    }
    public Jogador(int id, String nome, String dataNasc, String camisa, String timeJogador, float peso, int altura, int gols, int assists){
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.camisa = camisa;
        this.timeJogador = timeJogador;        
        this.peso = peso;
        this.altura = altura;
        this.gols = gols;
        this.assists = assists;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public String getCamisa() {
        return camisa;
    }

    public String getTimeJogador() {
        return timeJogador;
    }

    public int getAltura() {
        return altura;
    }

    public int getGols() {
        return gols;
    }

    public int getAssists() {
        return assists;
    }

    public float getPeso() {
        return peso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setCamisa(String camisa) {
        this.camisa = camisa;
    }

    public void setTimeJogador(String timeJogador) {
        this.timeJogador = timeJogador;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public static Jogador converter(Map<String, Object> registro) {
        int id = (Integer) registro.get("id");
        String nome = (String) registro.get("nome");
        String dataNasc = (String) registro.get("dataNasc");
        String timeJogador = (String) registro.get("timeJogador");
        int altura = (Integer) registro.get("altura");
        float peso = (float) registro.get("peso");
        String camisa = (String) registro.get("camisa");
        int gols = (Integer) registro.get("gols");
        int assists = (Integer) registro.get("assists");

        return new Jogador(id, nome, dataNasc, camisa, timeJogador, peso, altura, gols, assists);
    }

    public static List<Jogador> converterVarios(List<Map<String, Object>> registros) {
        ArrayList<Jogador> lista = new ArrayList<>();
        for (Map<String, Object> reg : registros) {
            lista.add(converter(reg));
        }
        return lista;
    }
}
