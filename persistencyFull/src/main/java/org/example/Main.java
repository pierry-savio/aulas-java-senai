package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SellDAO dao = new SellDAO();

        int option = -1;

        while (option != 0){
            System.out.println("\n=== Sistema de Vendas ===");
            System.out.println("1. Cadastrar Venda");
            System.out.println("2. Listar Vendas");
            System.out.println("3. Exportar para CSV");
            System.out.println("4. Exportar para JSON");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1 -> {
                    System.out.print("Nome do Produto: ");
                    String product = scanner.nextLine();
                    System.out.print("Categoria (ex: Eletrônicos, Livros, Roupas): ");
                    String category = scanner.nextLine();
                    System.out.print("Valor Unitário (ex: 49,98): ");
                    double value = scanner.nextDouble();
                    System.out.print("Quantidade: ");
                    int qtd = scanner.nextInt();

                    dao.save(new Sell(product, category, value, qtd));
                }
                case 2 ->{
                    List<Sell> sells = dao.listAll();
                    System.out.println("\n--- Vendas Registradas ---");
                    sells.forEach(s -> System.out.printf("[%d] %s (%s) - Qtd: %d - " +
                            "Preço: R$ %.2f - Total: R$ %.2f\n",
                            s.getId(), s.getProduct(), s.getCategory(), s.getQuantity(),
                            s.getUnitValue(), s.getTotalValue()));
                }
                case 3 ->{
                    List<Sell> sells = dao.listAll();
                    ExporterCSV.export(sells, "vendas.csv");
                }
                case 4 ->{
                    List<Sell> sells = dao.listAll();
                    ExporterJSON.export(sells, "vendas.json");
                }
                case 0 -> System.out.println("Saindo do sistema");
                default -> System.out.println("Escolha uma opção válida");
            }
        }
    }
}