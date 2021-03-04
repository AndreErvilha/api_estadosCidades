package com.andreervilha.evoluum.springboottest.utils;

import com.andreervilha.evoluum.springboottest.dto.DesafioDto;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.andreervilha.evoluum.springboottest.utils.FileOutputType.CSV;

public class FileOutputUtils {

    public OutputStream toCsv(HttpServletResponse response, List<DesafioDto> lista) {
        Logger logger = new Logger();
        logger.log("Convertendo conteúdo para CSV");
        try {
            OutputStream outputStream = response.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(outputStream, StandardCharsets.ISO_8859_1);
            String outputResult = toCsv(lista, true);
            writer.write(outputResult);
            writer.flush();
            writer.close();
            logger.log("Finalizado");
            return outputStream;
        } catch (Exception e) {
            logger.log("Houve um problema ao transformar conteúdo para CSV  -->", e.getMessage());
            return null;
        }
    }

    private String toCsv(List<DesafioDto> lista, boolean addHeader) throws IllegalAccessException {
        StringBuilder csv = new StringBuilder();

        if (addHeader) {
            csv.append(toFileRow(lista.get(0), CSV, true));
            csv.append(System.lineSeparator());
        }

        for (DesafioDto desafioDto : lista) {
            csv.append(toFileRow(desafioDto, CSV, false));
            csv.append(System.lineSeparator());
        }

        return csv.toString();
    }

    private String toFileRow(DesafioDto desafioDto, FileOutputType fileOutputType, boolean csvHeader) throws IllegalAccessException {
        if (fileOutputType == CSV) {
            return getCsvFrom(desafioDto, ";", csvHeader);
        }

        return null;
    }

    private String getCsvFrom(DesafioDto desafioDto, String delimiter, boolean isHeader) throws IllegalAccessException {
        StringBuilder line = new StringBuilder();
        for (Field field : desafioDto.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String fieldElement = isHeader ? field.getName() : field.get(desafioDto).toString();
            line.append(fieldElement).append(delimiter);
        }
        return line.toString();
    }

}
