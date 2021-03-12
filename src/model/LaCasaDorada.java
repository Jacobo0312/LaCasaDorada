package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class LaCasaDorada {

    public static final String SEPARATE = ",";

    private ArrayList<User> users;
    private ArrayList<Product> products;
    private ArrayList<Customer> customers;
    private ArrayList<Order> orders;
    private ArrayList<Employee> employees;

    public LaCasaDorada() {
        users = new ArrayList<User>();
        products = new ArrayList<Product>();
        customers = new ArrayList<Customer>();
        orders = new ArrayList<Order>();
        employees = new ArrayList<Employee>();
    }

    // GET and ADD for Users-------------------------------------------

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(String firstName, String lastName, String id, String user, String password) {
        users.add(new User(firstName, lastName, id, user, password));
    }

    // For verify user

    public User getUser(String name, String password) {
        User user = null;
        for (User s : users) {
            if (s.getUser().equals(name)) {
                if (s.getPassword().equals(password))
                    user = s;
            }
        }
        return user;
    }

    // Try binary search
    /*
     * public User getUser(String name, String password) { User user = null; int
     * index= Collections.binarySearch(users, name);
     * 
     * return user; }
     */

    // GET and ADD for Products----------------------------------

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProducts(String name, String[] ingredients, double[] pricePerSize, Boolean availability,
            String type) {
        products.add(new Product(name, ingredients, pricePerSize, availability, type));// Falta agregar los dos
                                                                                       // empleados
    }

    // GET and ADD for Customers----------------------------------

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void addCostumers(String firstName, String lastName, String id, String address, String phone,
            String comments) {

        // Comparador por apellido y nombre

        Comparator<Customer> lastNameAndFirstName = new Comparator<Customer>() {
            @Override
            public int compare(Customer obj1, Customer obj2) {
                String f1 = obj1.getFirstName();
                String l1 = obj1.getLastName();
                String f2 = obj2.getFirstName();
                String l2 = obj2.getLastName();

                if (l1.compareTo(l2) == 0) {

                    return f1.compareTo(f2);
                } else {
                    return l1.compareTo(l2);
                }
            }
        };

        // Agregar de forma ordenada
        Customer customer = new Customer(firstName, lastName, id, address, phone, comments);

        if (customers.isEmpty()) {
            customers.add(customer);
        } else {
            int i = 0;
            // Parametros al contrario para ordenar de forma descendente
            while (i < customers.size() && lastNameAndFirstName.compare(customer, customers.get(i)) < 0) {
                i++;
            }
            customers.add(i, customer);
        }
    }

    // GET and ADD for Order----------------------------------
    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void addOrders(ArrayList<OrdersDetails> products, Customer customer, Employee employeeCreate, LocalDateTime date, String comment) {
        orders.add(new Order(products, customer, employeeCreate, date, comment));
    }

    // GET and ADD for Employee----------------------------------
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void addEmployees(String firstName, String lastName, String id) {
        employees.add(new Employee(firstName, lastName, id));// Falta agregar los dos empleados
    }

    // Import data

    // PRODUCTS
    public void importProducts(String fileDirectory) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileDirectory));
        String line = br.readLine();
        while (line != null) {
            String[] parts = line.split(SEPARATE);
            String name = parts[0];
            String[] ingredients = parts[1].split(" ");
            double[] pricePerSize = { Double.parseDouble(parts[2]), Double.parseDouble(parts[3]) };
            boolean availability = Boolean.parseBoolean(parts[4]);
            String type = "DISH";// Por defecto, no se como agregar al csv

            addProducts(name, ingredients, pricePerSize, availability, type);
            line = br.readLine();
        }
        br.close();
    }

    // CUSTOMERS

    public void importCustomers(String fileDirectory) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileDirectory));
        String line = br.readLine();
        while (line != null) {
            String[] parts = line.split(SEPARATE);
            String firstName = parts[0];
            String lastName = parts[1];
            String id = parts[2];
            String address = parts[3];
            String phone = parts[4];
            String comments = parts[5];

            addCostumers(firstName, lastName, id, address, phone, comments);
            line = br.readLine();
        }
        br.close();
    }

    // ----------------------------------------------------------------------

}
