package model;

import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    private String firstName;
    private String lastName;
    private String id;
    //private Employee employeeCreate;
    //private Employee employeeModify;
    private Boolean availability;


    public Employee(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        //this.employeeCreate = employeeCreate;
        //this.employeeModify = employeeCreate;
        this.availability=true;
    }


    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String toString() {
        return getFirstName()+" "+getLastName();
    }
    
}
