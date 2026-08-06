package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigManager {
    private final String fileName;
    private final Gson gerson;

    public ConfigManager(String fileName) {
        this.fileName = fileName;
        this.gerson = new GsonBuilder().setPrettyPrinting().create();
    }

    public GameSettings load(){
        File file = new File(fileName);
        if (!file.exists()){
            System.out.println("Arquivo de configuração não encontrado. Usando valores padrão.");
            return new GameSettings();
        }
        try (FileReader reader = new FileReader(file)){
            GameSettings config = gerson.fromJson(reader, GameSettings.class);
            return (config != null) ? config : new GameSettings();
        }
        catch (IOException | JsonSyntaxException e){
            System.out.println("Erros ao carregar o arquivo de configuração JSON: " + e.getMessage());
            return new GameSettings();
        }
    }

    public void save(GameSettings config){
        try (FileWriter writer = new FileWriter(fileName)){
            gerson.toJson(config, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo de configurações JSON: " + e.getMessage());
        }
    }
}
