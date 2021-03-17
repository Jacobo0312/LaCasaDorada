package model;

import java.util.Arrays;

public class Product {
    private String name;
    private Ingredient [] ingredients;
    private double [] pricePerSize;
    private Boolean availability;
    private Employee employeeCreate;
    private Employee employeeModify;

    //Relations
    private Type type; //Enum

    public Product(String name, Ingredient[] ingredients, double[] pricePerSize, Boolean availability, String type,Employee employeeCreate) {
        this.name = name;
        this.ingredients = ingredients;
        this.pricePerSize = pricePerSize;
        this.availability = availability;
        this.type = Type.valueOf(type);
        this.employeeCreate = employeeCreate;
        this.employeeModify = employeeCreate;
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

    public void setIngredients(Ingredient[] ingredients) {
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


    public Employee getEmployeeCreate() {
        return this.employeeCreate;
    }

    public void setEmployeeCreate(Employee employeeCreate) {
        this.employeeCreate = employeeCreate;
    }

    public Employee getEmployeeModify() {
        return this.employeeModify;
    }

    public void setEmployeeModify(Employee employeeModify) {
        this.employeeModify = employeeModify;
    }
    
}
