package org.example;

public class Sell {
    private Integer id;
    private String product;
    private String category;
    private Double unitValue;
    private int quantity;

    public Sell(){}

    public Sell(String product, String category, Double unitValue, int quantity) {
        this.product = product;
        this.category = category;
        this.unitValue = unitValue;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(Double unitValue) {
        this.unitValue = unitValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalValue(){
        return this.unitValue * this.quantity;
    }
}
