package model;

/**
 * Customer
 */
public class Customer{

    private String firstName;
    private String lastName;
    private String id;//debe ser opcional
    private String address;
    private String phone;
    private String comments;
    private Employee employeeCreate;
    private Employee employeeModify;


    public Customer(String firstName, String lastName, String id, String address, String phone,String comments,Employee employeeCreate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.comments=comments;
        this.employeeCreate = employeeCreate;
        this.employeeModify = employeeCreate;
    }


    //Arreglar que el id sea opcional

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String toString() {
        return getFirstName()+" "+getLastName();
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