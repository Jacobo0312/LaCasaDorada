package model;

/**
 * Customer
 */
public class Customer{

    private String firstName;
    private String lastName;
    private String id="";//debe ser opcional
    private String address;
    private String phone;
    private String comments;


    public Customer(String firstName, String lastName, String id, String address, String phone,String comments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.comments=comments;
    }

  public Customer(String firstName, String lastName, String address, String phone,String comments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.comments=comments;
    }

    //Arreglar que el id sea opcional


}