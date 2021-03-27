package model;


public class Ingredient implements Comparable<Ingredient>{
    private String name;
    private Boolean availability;
    private Employee employeeCreate;
    private Employee employeeModify;
    


    public Ingredient(String name, Boolean availability,Employee employeeCreate) {
        this.name = name;
        this.availability=availability;
        this.employeeCreate = employeeCreate;
        this.employeeModify = employeeCreate;
 
    }

    public Ingredient(String name,Employee employeeCreate) {
        this.name = name;
        this.availability=true;
        this.employeeCreate = employeeCreate;
        this.employeeModify = employeeCreate;
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
