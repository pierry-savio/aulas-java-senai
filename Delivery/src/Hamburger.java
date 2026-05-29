public class Hamburger extends Product{

    public Hamburger(){
        super(1);
        this.name = "Hamburger";
        this.price = 20;
    }

    public Hamburger(int quantity){
        super(quantity);
        this.name = "Hamburger";
        this.price = 20;
    }
}
