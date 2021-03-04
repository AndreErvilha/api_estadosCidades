package com.andreervilha.evoluum.springboottest.dto;

import com.andreervilha.evoluum.springboottest.models.Cidade;

public class DesafioDto {

    private String idEstado;

    private String siglaEstado;

    private String regiaoNome;

    private String nomeCidade;

    private String nomeMesorregiao;

    private String nomeFormatado;

    public DesafioDto(String idEstado, String siglaEstado, String regiaoNome, String nomeCidade, String nomeMesorregiao, String nomeFormatado) {
        this.idEstado = idEstado;
        this.siglaEstado = siglaEstado;
        this.regiaoNome = regiaoNome;
        this.nomeCidade = nomeCidade;
        this.nomeMesorregiao = nomeMesorregiao;
        this.nomeFormatado = nomeFormatado;
    }

    public DesafioDto(Cidade cidade) {
        this.idEstado = String.valueOf(cidade
                .getMicroRegiao()
                .getMesoRegiao()
                .getEstado().getId());

        this.siglaEstado = cidade
                .getMicroRegiao()
                .getMesoRegiao()
                .getEstado()
                .getSigla();

        this.regiaoNome = cidade
                .getMicroRegiao()
                .getMesoRegiao()
                .getEstado()
                .getRegiao()
                .getNome();

        nomeCidade = cidade.getNome();

        this.nomeMesorregiao = cidade
                .getMicroRegiao()
                .getMesoRegiao()
                .getNome();

        this.nomeFormatado = cidade.getNome() + " / " + cidade
                .getMicroRegiao()
                .getMesoRegiao()
                .getEstado()
                .getSigla();
    }

    public DesafioDto() {
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }

    public String getRegiaoNome() {
        return regiaoNome;
    }

    public void setRegiaoNome(String regiaoNome) {
        this.regiaoNome = regiaoNome;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getNomeMesorregiao() {
        return nomeMesorregiao;
    }

    public void setNomeMesorregiao(String nomeMesorregiao) {
        this.nomeMesorregiao = nomeMesorregiao;
    }

    public String getNomeFormatado() {
        return nomeFormatado;
    }

    public void setNomeFormatado(String nomeFormatado) {
        this.nomeFormatado = nomeFormatado;
    }

}