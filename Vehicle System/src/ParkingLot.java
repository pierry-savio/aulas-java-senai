import java.util.ArrayList;

public class ParkingLot {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public ParkingLot(){};

    public ParkingLot(ArrayList<Vehicle> vehicles){
        this.vehicles = vehicles;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public void removeVehicle(String carPlate){
        for (int i = 0; i < vehicles.size(); i++){
            if (vehicles.get(i).getPlate().equals(carPlate)){
                vehicles.remove(i);
            }
        }
    }

    @Override
    public String toString(){

        String result = "";

        for (int i = 0; i<vehicles.size(); i++){
            result += (i+1) + " - " + vehicles.get(i) + "\n";
        }

        result += "Quantidade de veículos: " + vehicles.size();

        return result;
    }
}
