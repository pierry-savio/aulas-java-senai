public class Cake extends Product{

    public Cake(){
        super(1);
        this.name = "Cake";
        this.price = 45;
    }

    public Cake(int quantity){
        super(quantity);
        this.name = "Cake";
        this.price = 45;
    }
}
