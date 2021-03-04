package com.andreervilha.evoluum.springboottest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cidade extends AreaMenor {

    @JsonProperty("microrregiao")
    private MicroRegiao microRegiao;

    public Cidade() {
    }

    public Cidade(long id, String nome, MicroRegiao microRegiao) {
        super(id, nome);
        this.microRegiao = microRegiao;
    }

    public MicroRegiao getMicroRegiao() {
        return microRegiao;
    }

    public void setMicroRegiao(MicroRegiao microRegiao) {
        this.microRegiao = microRegiao;
    }

}
