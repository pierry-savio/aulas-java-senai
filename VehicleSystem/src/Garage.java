import java.lang.reflect.Array;
import java.util.ArrayList;

public class Garage{
    private ArrayList <Vehicle> vehicles = new ArrayList<>();
    private ArrayList <Car> cars = new ArrayList<>();
    private ArrayList <Truck> trucks = new ArrayList<>();
    private ArrayList <Motorcycle> motorcycles = new ArrayList<>();

    public Garage(){}

    public Garage(ArrayList<Car> cars, ArrayList<Truck> trucks, ArrayList<Motorcycle> motorcycles){
        this.cars = cars;
        this.trucks = trucks;
        this.motorcycles = motorcycles;
    }

    /*
    public ArrayList<?> getVehiclesByType(Type type) {

        switch (type) {
            case type.CAR:
                return cars;
            break;

            case type.TRUCK:
                return trucks;
            break;

            case type.MOTORCYCLE:
                return motorcycles;
            break;

            default:
                return vehicles;
            break;
        }
    }
    */

    public ArrayList<Vehicle> getVehicles(){
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles){
        this.vehicles = vehicles;
    }

    //Add
    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    //Remove
    public void removeVehicle(Vehicle vehicle){
        vehicles.remove(vehicle);
    }
}
