package model;

import java.util.ArrayList;
import java.util.Date;

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
    public ArrayList<Customer> getCustumers(){	
    	return customers;
    }
    
    public void addCostumers(String firstName, String lastName, String id, String address, String phone,String observations) {
    	customers.add(new Customer(firstName, lastName, id,  address,  phone,observations));
    }
  //GET and ADD for Order----------------------------------
    public ArrayList<Order> getOrders(){	
    	return orders;
    }
    
    public void addOrders(String code, Status status, ArrayList<Product> products, int[] amount, Customer customer, Employee employee, Date date, String Comment) {
    	orders.add(new Order(code, status,  products,  amount,  customer,  employee,  date,  Comment));
    }
  //GET and ADD for Employee----------------------------------   
    public ArrayList<Employee> getEmployees(){	
    	return employees;
    }
   
    public void addEmployees(String firstName, String lastName, String id) {
    	employees.add(new Employee( firstName, lastName,  id));
    }
    
    

}

 
