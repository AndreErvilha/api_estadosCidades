package com.andreervilha.evoluum.springboottest.api;

import com.andreervilha.evoluum.springboottest.interfaces.ApiRequestServiceInterface;
import com.andreervilha.evoluum.springboottest.models.Cidade;
import com.andreervilha.evoluum.springboottest.models.Estado;
import com.andreervilha.evoluum.springboottest.utils.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiRequestService implements ApiRequestServiceInterface {

    @Autowired
    private RequestUtils requestUtils;

    @Override
    public List getEstados() {
        return requestUtils.get(EndPoint.ESTADOS.toString(), Estado.class);
    }

    @Override
    public List getCidades(long estadoId) {
        String url = EndPoint.CIDADES.toString().replace("{UF}", String.valueOf(estadoId));
        return requestUtils.get(url, Cidade.class);
    }

    public List getInformacoesIBGE() {
        List<Estado> estados = getEstados();
        List<Cidade> cidades = new ArrayList<>();

        for (Estado estado : estados) {
            cidades.addAll(getCidades(estado.getId()));
        }

        return cidades;
    }

}