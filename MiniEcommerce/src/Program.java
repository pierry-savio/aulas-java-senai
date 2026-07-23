import java.util.Scanner;

public class Program {
    public static void main (String[] args) {

        cleanScreen();
        Cart cart = new Cart();
        Product computer = new Product("Computer", 1000, ProductType.PHYSICAL, 1);
        Product phone = new Product("Phone", 600, ProductType.PHYSICAL, 1);
        Product minecraft = new Product("Minecraft", 100, ProductType.DIGITAL, 1);
        Scanner sc = new Scanner(System.in);

        int option = 1;

        while (option != 4) {

            System.out.println("Choose one products: ");
            System.out.println("1 - Computer  | R$1000,00");
            System.out.println("2 - Phone     | R$600,00");
            System.out.println("3 - Minecraft | R$100,00");
            System.out.println("4 - PURCHASE");
            System.out.print("N: ");
            option = sc.nextInt();

            if (option != 4) {
            System.out.print("Quantity: ");
            int productQuantity = sc.nextInt();
            if (productQuantity < 1) {productQuantity = 1;}

            switch (option) {
                case 1:
                    computer.setQuantity(productQuantity);
                    cart.addProduct(computer);
                    break;

                case 2:
                    phone.setQuantity(productQuantity);
                    cart.addProduct(phone);
                    break;

                case 3:
                    minecraft.setQuantity(productQuantity);
                    cart.addProduct(minecraft);
                    break;
                }
            }
            cleanScreen();
        }
        System.out.println(cart);
        sc.close();
    }

    public static void cleanScreen(){
        for (int i = 0; i<80; i++){
            System.out.println();
        }
    }

    public static void cleanScreen(int lines){
        for (int i = 0; i<lines; i++){
            System.out.println();
        }
    }
}
