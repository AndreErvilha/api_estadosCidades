package com.andreervilha.evoluum.springboottest.interfaces;

import java.util.List;

public interface ApiRequestServiceInterface {
    List getEstados();

    List getCidades(long estadoId);

    List getInformacoesIBGE();
}