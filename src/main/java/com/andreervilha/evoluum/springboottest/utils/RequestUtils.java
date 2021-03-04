package com.andreervilha.evoluum.springboottest.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.List;

import static com.andreervilha.evoluum.springboottest.utils.TempoUtils.aguardar;

@Component
public class RequestUtils {

    private static int NUMERO_MAXIMO_TENTATIVAS = 15;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = new Logger();

    public List get(String endPoint, Class objectClass) {
        int tentativa = 1;
        List resultado = performRequest(endPoint, objectClass, tentativa);

        while (deveTentarNovamente(resultado, tentativa)) {
            aguardar(2);
            resultado = performRequest(endPoint, objectClass, ++tentativa);
        }

        return resultado;
    }

    private boolean deveTentarNovamente(List resultado, int tentativa) {
        return resultado == null && tentativa < NUMERO_MAXIMO_TENTATIVAS;
    }

    private List performRequest(String endPoint, Class objectClass, int tentativa) {
        try {
            logger.log("[Tentativa " + tentativa + "] Recuperando conteúdo de", endPoint);

            byte[] responseBytes = this.restTemplate
                    .getForObject(endPoint, byte[].class);

            logger.log("Recuperado");
            logger.log("Descompactando");

            InputStream inputStream = new ByteArrayInputStream(responseBytes);
            String json = getStringJson(inputStream);

            logger.log("Descompactado");
            logger.log("Mapeando para objetos");

            ObjectMapper objectMapper = new ObjectMapper();
            List lista = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, objectClass));

            logger.log("Requisição finalizada, Dados Recuperados **OK");

            return lista;
        } catch (Exception e) {
            logger.log("Falha na requisição, Dados não Recuperados **" + e.getMessage());
            return null;
        }
    }

    private String getStringJson(InputStream gzipInputStream) throws IOException {
        String charset = "UTF-8";
        Reader reader = new InputStreamReader(gzipInputStream, charset);
        Writer writer = new StringWriter();

        char[] buffer = new char[10240];
        for (int length = 0; (length = reader.read(buffer)) > 0; ) {
            writer.write(buffer, 0, length);
        }
        return writer.toString();
    }
}