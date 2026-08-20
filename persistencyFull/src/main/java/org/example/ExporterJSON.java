package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ExporterJSON {

    public static void export(List<Sell> sells, String pathFile){
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try{
            mapper.writeValue(new File(pathFile), sells);
            System.out.println("Arquivo JSON gerado com sucesso: " + pathFile);
        } catch (IOException e) {
            System.out.println("Erro ao exportar JSON: " + e.getMessage());
        }
    }
}
