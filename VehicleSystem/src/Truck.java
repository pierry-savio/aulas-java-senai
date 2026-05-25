public class Truck extends Vehicle{
    public Truck(Model model, String horn, Double maxPeed) {
        super(model, horn, maxPeed);
        this.type = Type.TRUCK;
    }
}
