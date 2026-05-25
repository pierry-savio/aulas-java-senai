import java.util.Scanner;

public class LittleFarm {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 0;

        while (n != 4) {

            System.out.println("-----------------------");
            System.out.println("| Escolha um animal:  |");
            System.out.println("| 1: Cachorro         |");
            System.out.println("| 2: Gato             |");
            System.out.println("| 3: Vaca             |");
            System.out.println("| 4: Sair             |");
            System.out.println("-----------------------");
            System.out.print("N: ");
            n = sc.nextInt();

            System.out.println();

            Animal animal;

            switch (n){
                case 1:
                    //poliFORmismo
                    animal = new Dog();
                break;

                case 2:
                    animal = new Cat();
                break;

                case 3:
                    animal = new Cow();
                break;

                default:
                    animal = new Dog();
                break;
            }

            if (n != 4) {
                System.out.println(animal.throwSound());
            }
            System.out.println();
        }
    }
}