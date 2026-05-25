public class Motorcycle extends Vehicle{
    public Motorcycle(Model model, String horn, Double maxPeed) {
        super(model, horn, maxPeed);
        this.type = Type.MOTORCYCLE;
    }
}
