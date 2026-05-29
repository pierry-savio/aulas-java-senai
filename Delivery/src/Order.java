import java.util.ArrayList;

public class Order {

    private ArrayList<Product> products = new ArrayList<>();

    public Order(){}

    public Order (ArrayList<Product> products){
        this.products = products;
    }

    public ArrayList<Product> getProducts(){
        return products;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public double calculateTotal(){
        double sum = 0.0;

        for (Product p : products){
            sum += p.calculateTotal();
        }
        return sum;
    }
}
