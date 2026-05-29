public abstract class Product {
    protected String name;
    protected double price;
    protected int quantity;
    protected double total;

    public Product(int quantity){
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public double calculateTotal(){
        return price*quantity;
    }

    public String toString(){
        return name + ": R$" + String.format("%.2f", price) + " x " + quantity + " = R$" + calculateTotal();
    }
}
