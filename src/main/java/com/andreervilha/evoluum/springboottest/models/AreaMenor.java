package com.andreervilha.evoluum.springboottest.models;

import java.util.Objects;

public class AreaMenor extends EntidadeAbstrata {

    private long id;
    private String nome;

    public AreaMenor() {
    }

    public AreaMenor(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        AreaMenor areaMenor = (AreaMenor) o;
        return nome.equals(areaMenor.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
