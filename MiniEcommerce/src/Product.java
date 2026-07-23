public class Product {
    private String name;
    private double price;
    private ProductType productType;
    private int quantity;

    public Product (String name, double price, ProductType productType, int quantity){
        this.name = name;
        this.price = price;
        this.productType = productType;
        this.quantity = quantity;
    }

    //GETTERS & SETTERS
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    //Price
    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    //Type
    public ProductType getProductType(){
        return productType;
    }

    public void setProductType(ProductType productType){
        this.productType = productType;
    }

    //Quantity
    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    //Total
    public double calculateTotal(){
        return quantity * price;
    }

    @Override
    public String toString(){
        return name + " - " + EnumConverter.enumToString(productType) + " product: R$" + String.format("%.2f", price) + " * " + quantity + " = R$" + String.format("%.2f", calculateTotal());
    }
}
