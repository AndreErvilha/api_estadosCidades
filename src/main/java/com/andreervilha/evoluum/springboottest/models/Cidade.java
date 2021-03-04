package com.andreervilha.evoluum.springboottest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cidade extends AreaMenor {

    @JsonProperty("microrregiao")
    private MicroRegiao microRegiao;
    @JsonProperty("regiao-imediata")
    private MicroRegiao regiaoImediata;

    public Cidade() {
    }

    public Cidade(long id, String nome, MicroRegiao microRegiao, MicroRegiao regiaoImediata) {
        super(id, nome);
        this.microRegiao = microRegiao;
        this.regiaoImediata = regiaoImediata;
    }

    public MicroRegiao getMicroRegiao() {
        return microRegiao;
    }

    public void setMicroRegiao(MicroRegiao microRegiao) {
        this.microRegiao = microRegiao;
    }

    public MicroRegiao getRegiaoImediata() {
        return regiaoImediata;
    }

    public void setRegiaoImediata(MicroRegiao regiaoImediata) {
        this.regiaoImediata = regiaoImediata;
    }
}
