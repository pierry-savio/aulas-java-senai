import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot();
        cleanScreen();

        System.out.print("Quantidade de veículos: ");
        int quantity = sc.nextInt();

        cleanScreen();

        for (int i = 0; i < quantity; i++){
            System.out.println("Veículo #" + (i+1));
            System.out.print("Vehicle Plate: ");
            String plate = sc.next();
            System.out.println("Model: ");
            System.out.println("1 - Carro");
            System.out.println("2 - Moto");
            System.out.println("3 - Ônibus");
            System.out.print("N: ");
            int nModel = sc.nextInt();
            Models model;

            switch (nModel){
                case 1:  model = Models.CAR;        break;
                case 2:  model = Models.MOTORCYCLE; break;
                case 3:  model = Models.BUS;        break;
                default: model = Models.EMPTY;      break;
            }
            parkingLot.addVehicle(new Vehicle(plate, model));

            cleanScreen();
        }

        System.out.println("Veículos adicionados com sucesso!");
        System.out.println("pressione enter para continuar...");
        sc.nextLine();

        cleanScreen();

        System.out.println("VEÍCULOS CADASTRADOS");
        System.out.println(parkingLot);
        sc.close();
    }

    public static void cleanScreen(){
        for (int i = 0; i<70; i++){
            System.out.println();
        }
    }

    public static void cleanScreen(int lines){
        for (int i = 0; i<lines; i++){
            System.out.println();
        }
    }
}