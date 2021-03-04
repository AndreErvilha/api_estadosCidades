    package com.andreervilha.evoluum.springboottest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MesoRegiao extends AreaMenor {

    @JsonProperty("UF")
    private Estado estado;

    public MesoRegiao() {
    }

    public MesoRegiao(long id, String nome, Estado estado) {
        super(id, nome);
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}