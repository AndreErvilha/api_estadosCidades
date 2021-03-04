package com.andreervilha.evoluum.springboottest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Area extends EntidadeAbstrata {

    @JsonProperty("id")
    private long id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("sigla")
    private String sigla;

    Area(){}

    Area(long id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Area{" +"id=" + id +", nome='" + nome + '\'' +", sigla='" + sigla + '\'' +'}';
    }
}
