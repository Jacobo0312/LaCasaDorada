package model;


public class Ingredient implements Comparable<Ingredient>{
    private String name;
    private Boolean availability;


    public Ingredient(String name, Boolean availability) {
        this.name = name;
        this.availability=availability;
 
    }

    public Ingredient(String name) {
        this.name = name;
        this.availability=true;;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Boolean isAvailability() {
        return this.availability;
    }

    public String getAvailability() {
        String av;
        if (this.availability){
            av="HABILITADO";
        }else{
            av="DESHABILITADO";
        }
        return av;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
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
