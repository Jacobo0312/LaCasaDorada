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


    public Customer(String firstName, String lastName, String id, String address, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.address = address;
        this.phone = phone;
    }



}