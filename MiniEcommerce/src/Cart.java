import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> products = new ArrayList<>();

    public Cart(){}

    public Cart(ArrayList<Product> products){
        this.products = products;
    }

    public ArrayList<Product> getProducts(){
        return products;
    }

    public void setProducts (ArrayList<Product> products){
        this.products = products;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProductByName(String name){
        for (int i = 0; i < products.size(); i++){
            Product product = products.get(i);
            if (product.getName().equals(name)){
                products.remove(product);
            }
        }
    }

    public double calculateTotal(){
        double total = 0;
        for (Product p : products){
            total += p.calculateTotal();
        }
        return total;
    }

    @Override
    public String toString(){

        String result = "- CART -\n";

        for (int i = 0; i < products.size(); i++){
            result += (i+1) + " - " + products.get(i) + "\n";
        }
        result += "= R$" + calculateTotal();
        return result;
    }
}
