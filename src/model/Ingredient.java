package model;


public class Ingredient implements Comparable<Ingredient>{
    private String name;
    private StatusIngredients status;


    public Ingredient(String name, String status) {
        this.name = name;
        this.status = StatusIngredients.valueOf(status);
    }

    public Ingredient(String name) {
        this.name = name;
        this.status = StatusIngredients.HABILITADO;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusIngredients getStatus() {
        return this.status;
    }

    public void setStatus(StatusIngredients status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public int compareTo(Ingredient o) {
    
        return this.name.compareTo(o.getName());
    }






}
