package model;

import java.util.ArrayList;

public class LaCasaDorada {

    private ArrayList<User> users;
    private ArrayList<Product> products;
    private ArrayList<Customer> customers;
    private ArrayList<Order> orders;
    private ArrayList<Employee> employees;



    public LaCasaDorada(ArrayList<User> users, ArrayList<Product> products, ArrayList<Customer> customers, ArrayList<Order> orders, ArrayList<Employee> employees) {
        users = new ArrayList<User>();
        products = new ArrayList<Product>();
        customers = new ArrayList<Customer>();
        orders = new ArrayList<Order>();
        employees = new ArrayList<Employee>();
    }

    //GET and ADD for Users-------------------------------------------
    
    public ArrayList<User> getUsers() {
        return users;
    }

    public void addBillboard(String firstName, String lastName, String id,String user, String passsword) {
        users.add(new User( firstName,  lastName,  id, user,  passsword));
    }

    //GET and ADD for Products----------------------------------

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProducts(String name, String[] ingredients, int[] pricePerSize, Boolean availability, String type) {
        products.add(new Product(  name,  ingredients,  pricePerSize, availability,  type));
    }

//GET and ADD for Customers----------------------------------

}

 
