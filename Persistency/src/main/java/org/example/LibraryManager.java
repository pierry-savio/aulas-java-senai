package org.example;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class LibraryManager {
    private final String fileName;
    private final XmlMapper xmlMapper;

    public LibraryManager(String fileName){
        this.fileName = fileName;
        this.xmlMapper = XmlMapper.builder()
            .enable(SerializationFeature.INDENT_OUTPUT)
            .build();
    }

    public Library load(){
        File file = new File(fileName);
        if (!file.exists()){
            System.out.println("Creating new library...");
            return new Library();
        }
        try {
            // Lê o arquivo XML e converte para o objeto Biblioteca
            return xmlMapper.readValue(file, Library.class);
        }
        catch (JacksonException e) {
            System.out.println("Erro ao ler o arquivo XML: " + e.getMessage());
            e.printStackTrace();
            return new Library();
        }
    }
    public void save(Library library){
        try{
            xmlMapper.writeValue(new File(fileName), library);
        }catch (JacksonException e){
            System.out.println("Erro ao salvar o arquivo XML: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
