import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Quantidade de veículos: ");
        int quantity = sc.nextInt();

        System.out.println();

        Garage garage = new Garage();

        for (int i = 0; i<quantity; i++){
            System.out.println("=== VEÍCULO #" + (i+1) + " ===");
            System.out.println();
            System.out.println("   Escolha um modelo: ");
            System.out.println("      1 - VOLKSWAGEN");
            System.out.println("      2 - FIAT");
            System.out.println("      3 - CHEVROLET");
            System.out.print  ("      N: ");
            int modelNumber = sc.nextInt();

            Model model = Model.SEM_TIPO;

            switch (modelNumber){
                case 1:
                    model = Model.VOLKSWAGEN;
                break;

                case 2:
                    model = Model.FIAT;
                break;

                case 3:
                    model = Model.CHEVROLET;
                break;
            }

            System.out.println();
            System.out.println("   Escolha o tipo: ");
            System.out.println("      1 - Carro");
            System.out.println("      2 - Caminhão");
            System.out.println("      3 - Moto");
            System.out.print  ("      N: ");
            int typeNumber = sc.nextInt();

            System.out.println();

            System.out.print("Buzina: ");
            sc.nextLine();
            String horn = sc.nextLine();

            System.out.print("Velocidade máxima: ");
            Double maxSpeed = sc.nextDouble();

            switch (typeNumber){
                case 1:
                    garage.addVehicle(new Car(model, horn, maxSpeed));
                break;

                case 2:
                    garage.addVehicle(new Truck(model, horn, maxSpeed));
                break;

                case 3:
                    garage.addVehicle(new Motorcycle(model, horn, maxSpeed));
                break;
            }
            System.out.println();
        }

        System.out.println("=== VEÍCULOS === ");
        System.out.println();
        for (Vehicle vehicle : garage.getVehicles()){
            System.out.println(vehicle);
        }
    }
}