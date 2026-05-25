public class Car extends Vehicle{
    public Car(Model model, String horn, Double maxPeed) {
        super(model, horn, maxPeed);
        this.type = Type.CAR;
    }
}
