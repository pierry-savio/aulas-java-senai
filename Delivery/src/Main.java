import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        cleanScreen();

        Scanner sc = new Scanner(System.in);

        Hamburger ham = new Hamburger();
        Fries fri = new Fries();
        Cake cak = new Cake();

        Order order = new Order();

        int loop = 1;

        while (loop == 1) {

            System.out.println("Escolha um produto: ");
            System.out.println("1 - Hamburger --- R$" + ham.getPrice());
            System.out.println("2 - Fries ------- R$" + fri.getPrice());
            System.out.println("3 - Cake -------- R$" + cak.getPrice());
            System.out.print("N: ");
            int n = sc.nextInt();

            System.out.println();

            System.out.print("Quantidade: ");
            int quantity = sc.nextInt();

            System.out.println();

            switch (n) {
                case 1:
                    order.addProduct(new Hamburger(quantity));
                    break;

                case 2:
                    order.addProduct(new Fries(quantity));
                    break;

                case 3:
                    order.addProduct(new Cake(quantity));
                    break;
            }

            cleanScreen();

            System.out.println("Produto adicionado com sucesso!");

            System.out.println();

            System.out.println("Deseja fazer outro pedido?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            System.out.print("N: ");
            loop = sc.nextInt();

            cleanScreen();
        }

        System.out.println("=== PEDIDO ===");

        System.out.println();

        for (int i = 0; i<order.getProducts().size(); i++){
            System.out.println(order.getProducts().get(i));
        }

        System.out.println("TOTAL DO PEDIDO: R$" + String.format("%.2f", order.calculateTotal()));
    }

    public static void cleanScreen(){for(int i=0; i<80; i++) System.out.println();}
    public static void cleanScreen(int lines){for(int i=0; i<lines; i++) System.out.println();}
}