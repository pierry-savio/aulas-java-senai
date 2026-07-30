package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final LibraryManager manager = new LibraryManager("biblioteca.xml");
    private static final Scanner scanner = new Scanner(System.in);
    private static Library library;

    public static void main(String[] args) {
        library = manager.load();
        System.out.println("Bem-vindo(a) a biblioteca dos estdos!");
        System.out.println(library.getBooks().size() + " livros(s) carregado(s).");

        int option = 0;
        while (option != 3){
            showMenu();
            try{
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option){
                    case 1: addBook();                                  break;
                    case 2: listBooks();                                break;
                    case 3: System.out.println("Salvando e saindo..."); break;
                    default: System.out.println("Opção inválida!");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Erro: Por favor, digite um número.");
                scanner.nextLine();
            }
        }
        manager.save(library);
        System.out.println("Salvo com sucesso em 'biblioteca.xml'.");
        scanner.close();
    }
    private static void showMenu(){
        System.out.println("------------MENU-----------");
        System.out.println("1 - Adicionar novo livro   ");
        System.out.println("2 - Listar todos os livros ");
        System.out.println("3 - Sair e salvar          ");
        System.out.print("Escolha uma opção: ");
    }

    private static void addBook(){
        System.out.println("------ADICIONAR LIVRO------");
        try{
            System.out.print("Título: ");
            String title = scanner.nextLine();

            System.out.print("Autor: ");
            String author = scanner.nextLine();

            System.out.print("Ano: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            library.getBooks().add(new Book(title, author, year));
        }
        catch (InputMismatchException e){
            System.out.println("Erro: o ano deve ser um número!");
            scanner.nextLine();
        }
    }
    private static void listBooks(){
        System.out.println("----LIVROS NA BIBLIOTECA----");
        if (library.getBooks().isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        }else{
            library.getBooks().forEach(System.out::println);
        }
    }
}