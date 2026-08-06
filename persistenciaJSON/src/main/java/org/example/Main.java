package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final ConfigManager manager = new ConfigManager("game_config.json");
    private static final Scanner scanner = new Scanner(System.in);
    private static GameSettings configurations;

    public static void main (String[] args){
        configurations = manager.load();
        System.out.println("Painel de configurações do jogo");
        int option = 0;
        while (option != 6){
            showMenu();
            try{
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option){
                    case 1: seeConfigurations();                             break;
                    case 2: changePlayerName();                              break;
                    case 3: changeDifficultyLevel();                         break;
                    case 4: changeAudio();                                   break;
                    case 5: changeResolution();                              break;
                    case 6: System.out.println("Salvando configurações..."); break;
                    default: System.out.println("Opção inválida!!!");        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite um número.");
                scanner.nextLine();
            }
        }
        manager.save(configurations);
        System.out.println("Configurações salvas em 'config_jogo.json");
    }
    private static void showMenu(){
        System.out.println("\n--- MENU DE CONFIGURAÇÕES ---");
        System.out.println("[1] - Ver Configurações Atuais");
        System.out.println("[2] - Alterar nome de Jogador");
        System.out.println("[3] - Alterar nível de dificuldade (1-3)");
        System.out.println("[4] - Habilitar/Desabilitar Áudio");
        System.out.println("[5] - Alterar resolução");
    }
    private static void seeConfigurations(){
        System.out.println(configurations.toString());
    }
    private static void changePlayerName(){
        System.out.println("Digite o novo nome do jogador: ");
        String newName = scanner.nextLine();
        configurations.setPlayerName(newName);
        System.out.println("Nome do jogador alterado para: " + newName);
    }
    private static void changeAudio() {
        boolean currentAudio = configurations.isAudioEnabled();
        configurations.setAudioEnabled(!currentAudio);
        String newStatus = configurations.isAudioEnabled() ? "HABILITADO" : "DESABILITADO";
        System.out.println("Áudio agora está: " + newStatus);
    }
    private static void changeDifficultyLevel() {
        System.out.println("Digite o novo nível de dificuldade (1 = Fácil, 2 = Médio, 3 = Difícil");
        try {
            int newLevel = scanner.nextInt();
            scanner.nextLine();
            if (newLevel >= 1 && newLevel <= 3) {
                configurations.setDifficultyLevel((newLevel));
                System.out.println("Nivel de dificuldade alterado para: " + newLevel);
            } else {
                System.out.println("Nível inválido. Use 1, 2 ou 3.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida: Digite um número");
            scanner.nextLine();
        }
    }
    private static void changeResolution(){
        System.out.println("Digite a nova resolução: ");
        String newResolution = scanner.nextLine();
        configurations.setScreenResolution(newResolution);
        System.out.println("Nova resolução alterada para: " + newResolution);
    }
}
