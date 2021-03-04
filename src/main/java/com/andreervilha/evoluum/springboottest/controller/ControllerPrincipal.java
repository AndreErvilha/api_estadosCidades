package com.andreervilha.evoluum.springboottest.controller;

import com.andreervilha.evoluum.springboottest.api.ApiRequestService;
import com.andreervilha.evoluum.springboottest.dto.DesafioDto;
import com.andreervilha.evoluum.springboottest.models.AreaMenor;
import com.andreervilha.evoluum.springboottest.models.Cidade;
import com.andreervilha.evoluum.springboottest.utils.FileOutputUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
public class ControllerPrincipal {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private ApiRequestService apiRequestService;

    private List<DesafioDto> listaInformacoesIbge;

    private List<Cidade> listaCidades;

    private HashSet<Cidade> ultimasCidadesPesquisadas = new HashSet<>(50);

    @RequestMapping(value = "/json", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    public List json() {
        return listaInformacoesIbge;
    }

    @RequestMapping(value = "/csv", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    public OutputStream csv(HttpServletResponse response) {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=infoCidadesIBGE.csv;");
        return new FileOutputUtils().toCsv(response, listaInformacoesIbge);
    }

    @RequestMapping(value = "/cidades/{nomeCidade}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    public long getCidade(@PathVariable("nomeCidade") String nomeCidade) {
        AreaMenor cidadeParam = new AreaMenor(0, nomeCidade);

        if (ultimasCidadesPesquisadas.contains(cidadeParam)) {
            Cidade cidadeCache = ultimasCidadesPesquisadas.stream()
                    .filter(c -> nomeCidade.equals(c.getNome()))
                    .findFirst()
                    .orElse(null);

            return cidadeCache.getId();
        }

        Cidade cidade = listaCidades.stream()
                .filter(c -> nomeCidade.equals(c.getNome()))
                .findFirst()
                .orElse(null);

        ultimasCidadesPesquisadas.add(cidade);
        return cidade.getId();
    }

    @EventListener(ApplicationReadyEvent.class)
    private void getListaInformacoesIBGE() {
        listaCidades = apiRequestService.getInformacoesIBGE();

        listaInformacoesIbge = new ArrayList<>();
        for (Cidade cidade : listaCidades) {
            listaInformacoesIbge.add(new DesafioDto(cidade));
        }
    }
}