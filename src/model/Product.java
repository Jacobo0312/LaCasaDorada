package model;

public class Product {
    private String name;
    private String [] ingredients;
    private int [] pricePerSize;
    private Boolean availability;

    //Relations
    private Type type; //Enum

    public Product(String name, String[] ingredients, int[] pricePerSize, Boolean availability, String type) {
        this.name = name;
        this.ingredients = ingredients;
        this.pricePerSize = pricePerSize;
        this.availability = availability;
        this.type = Type.valueOf(type);
    }


    
}
