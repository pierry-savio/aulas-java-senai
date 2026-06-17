import java.util.Scanner;

public class Main{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        PetShop petShop = new PetShop();

        cleanScreen();

        System.out.print("Quantidade de animais: ");
        int quantity = sc.nextInt();

        cleanScreen();

        for (int i = 0; i<quantity; i++){
            System.out.println("ANIMAL #" + (i+1));
            sc.nextLine();
            System.out.print("Nome: ");
            String name = sc.nextLine();
            System.out.print("Idade: ");
            int age = sc.nextInt();
            System.out.println("Raça:");
            System.out.println("  1 - Gato");
            System.out.println("  2 - Cachorro");
            System.out.println("  3 - Pato");
            System.out.print("N: ");
            int type = sc.nextInt();

            switch (type){
                case 1: petShop.addAnimal(new Cat(name, age));  break;
                case 2: petShop.addAnimal(new Dog(name, age));  break;
                case 3: petShop.addAnimal(new Duck(name, age)); break;
            }
            cleanScreen();
        }
        System.out.println("Animais cadastrados com sucesso!");
        System.out.println("pressione enter para continuar...");
        sc.nextLine();

        cleanScreen();

        System.out.println("PETSHOP");
        System.out.println("- Animais cadastrados -");
        System.out.println(petShop);
    }

    public static void cleanScreen(){
        for (int i = 0; i<70; i++){
            System.out.println();
        }
    }

    public static void cleanScreen(int lines){
        for (int i = 0; i<lines; i++){

        }
    }
}
