public class Vehicle {
    private String plate;
    private Models model;

    public Vehicle(String plate, Models model){
        this.plate = plate;
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setCarPlate(String plate) {
        this.plate = plate;
    }

    public Models getModel() {
        return model;
    }

    public void setModel(Models model) {
        this.model = model;
    }

    @Override
    public String toString(){
        return model.toString() + " | " + plate;
    }
}
