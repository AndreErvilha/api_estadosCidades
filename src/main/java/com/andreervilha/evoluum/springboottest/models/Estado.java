package com.andreervilha.evoluum.springboottest.models;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Estado extends Area {

    @JsonProperty("regiao")
    private Area regiao;

    public Estado() {
        super();
    }

    public Estado(long id, String nome, String sigla, Area regiao) {
        super(id, nome, sigla);
        this.regiao = regiao;
    }

    public Area getRegiao() {
        return regiao;
    }

    @Override
    public String toString() {
        return "Estado{" + super.toString() + "regiao=" + regiao + '}';
    }
}