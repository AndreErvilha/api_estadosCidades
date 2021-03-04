package com.andreervilha.evoluum.springboottest.api;

public enum EndPoint {

    ESTADOS("https://servicodados.ibge.gov.br/api/v1/localidades/estados"),

    CIDADES("https://servicodados.ibge.gov.br/api/v1/localidades/estados/{UF}/municipios");

    private String endpoint;

    EndPoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public String toString() {
        return this.endpoint;
    }
}