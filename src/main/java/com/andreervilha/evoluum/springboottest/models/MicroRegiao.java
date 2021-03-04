package com.andreervilha.evoluum.springboottest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MicroRegiao extends AreaMenor {

    @JsonProperty("mesorregiao")
    private MesoRegiao mesoRegiao;
    @JsonProperty("regiao-intermediaria")
    private MesoRegiao regiaoIntermediaria;

    public MicroRegiao() {
    }

    public MicroRegiao(long id, String nome, MesoRegiao mesoRegiao, MesoRegiao regiaoIntermediaria) {
        super(id, nome);
        this.mesoRegiao = mesoRegiao;
        this.regiaoIntermediaria = regiaoIntermediaria;
    }

    public MesoRegiao getMesoRegiao() {
        return mesoRegiao;
    }

    public MesoRegiao getRegiaoIntermediaria() {
        return regiaoIntermediaria;
    }

    public void setRegiaoIntermediaria(MesoRegiao regiaoIntermediaria) {
        this.regiaoIntermediaria = regiaoIntermediaria;
    }
}