package org.example;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final ContactDAO dao = new ContactDAO();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Database.createTable();

        System.out.println("Agenda de contatos");
        int option = 0;
        while (option != 5){
            showMenu();
            try{
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option){
                    case 1: addContact();                             break;
                    case 2: listContacts();                           break;
                    case 3: updateContact();                          break;
                    case 4: deleteContact();                          break;
                    case 5: System.out.println("Encerrando...");      break;
                    default: System.out.println("Opção inválida!!!"); break;
                }
            }catch (InputMismatchException e){
                System.out.println("Erro: Por favor, digite um número.");
                scanner.nextLine();
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n--- Agenda ---");
        System.out.println("1-| Adicionar contato ");
        System.out.println("2-| Listar contatos ");
        System.out.println("3-| Atualizar contato ");
        System.out.println("4-| Deletar contato ");
        System.out.println("5-| Sair ");
        System.out.println("Escolha uma opção: ");
    }

    private static void addContact() {
        System.out.println("\n--- Adicionar Contato ---");
        System.out.println("Nome: ");
        String name = scanner.nextLine();
        System.out.println("Telefone: ");
        String phoneNumber = scanner.nextLine();
        dao.add(new Contact(name, phoneNumber));
        System.out.println("Contato salvo com sucesso");
    }

    private static void listContacts() {
        System.out.println("\n--- Lista de Contatos ---");
        List<Contact> contacts = dao.list();
        if (contacts.isEmpty()){
            System.out.println("Nenhum contato cadastrado.");
        }
        else{
            contacts.forEach(System.out::println);
        }
    }

    private static void updateContact() {
        System.out.println("\n--- Atualizar Contato ---");
        System.out.println("Digite o Id o contato a ser atualizado: ");
        try{
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Novo nome: ");
            String name = scanner.nextLine();
            System.out.println("Novo telefone: ");
            String phoneNumber = scanner.nextLine();
            dao.update(new Contact(id, name, phoneNumber));
            System.out.println("Contato atualizado com sucesso!!!");
        }catch (InputMismatchException e){
            System.out.println("ID inválido. Digite um número.");
            scanner.nextLine();
        }
    }

    private static void deleteContact() {
        System.out.println("\n--- Remover Contato ---");
        System.out.println("Digite o ID do contato a ser removido: ");
        try{
            int id = scanner.nextInt();
            scanner.nextLine();
            dao.delete(id);
            System.out.println("Contato removido com sucesso!!!");
        }catch (InputMismatchException e){
            System.out.println("ID inválido. Digite um número.");
            scanner.nextLine();
        }
    }
}