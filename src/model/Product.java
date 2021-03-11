package model;

import java.util.Arrays;

public class Product {
    private String name;
    private String [] ingredients;
    private double [] pricePerSize;
    private Boolean availability;

    //Relations
    private Type type; //Enum

    public Product(String name, String[] ingredients, double[] pricePerSize, Boolean availability, String type) {
        this.name = name;
        this.ingredients = ingredients;
        this.pricePerSize = pricePerSize;
        this.availability = availability;
        this.type = Type.valueOf(type);
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return Arrays.toString(this.ingredients);
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public String getPricePerSize() {
        return Arrays.toString(this.pricePerSize);
    }


    public double [] getPricePerSizeInt() {
        return pricePerSize;
    }


    public void setPricePerSize(double[] pricePerSize) {
        this.pricePerSize = pricePerSize;
    }

    public Boolean isAvailability() {
        return this.availability;
    }

    public Boolean getAvailability() {
        return this.availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public String getType() {
        return this.type.toString();
    }

    public void setType(Type type) {
        this.type = type;
    }

    
}
