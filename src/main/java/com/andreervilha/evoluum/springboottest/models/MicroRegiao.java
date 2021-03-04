package com.andreervilha.evoluum.springboottest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MicroRegiao extends AreaMenor {

    @JsonProperty("mesorregiao")
    private MesoRegiao mesoRegiao;

    public MicroRegiao() {
    }

    public MicroRegiao(long id, String nome, MesoRegiao mesoRegiao) {
        super(id, nome);
        this.mesoRegiao = mesoRegiao;
    }

    public MesoRegiao getMesoRegiao() {
        return mesoRegiao;
    }

    public void setMesoRegiao(MesoRegiao mesoRegiao) {
        this.mesoRegiao = mesoRegiao;
    }
}