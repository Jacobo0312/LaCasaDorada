package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LaCasaDorada {

    public static final String SEPARATE = ",";
    public static int CODE_ORDER = 0;// revisar con la serializacion

    private ArrayList<User> users;
    private ArrayList<Product> products;
    private ArrayList<Customer> customers;
    private ArrayList<Order> orders;
    private ArrayList<Employee> employees;
    private User admin;

    public LaCasaDorada() {
        users = new ArrayList<User>();
        products = new ArrayList<Product>();
        customers = new ArrayList<Customer>();
        orders = new ArrayList<Order>();
        employees = new ArrayList<Employee>();
        admin = new User("Juan", "Jacobo", "1006107372", "1", "1");
        users.add(admin);
        // addUser("Juan", "Jacobo", "1006107372", "1", "1");// Admin
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
    public User getUser(String name, String password) {
        User user = null;
        int index = Collections.binarySearch(users, name);

        return user;
    }
    */

    // GET and ADD for Products----------------------------------

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProducts(String name, String[] ingredients, double[] pricePerSize, Boolean availability, String type,
            Employee employeeCreate) {
        products.add(new Product(name, ingredients, pricePerSize, availability, type, employeeCreate));
    }

    // GET and ADD for Customers----------------------------------

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void addCustomers(String firstName, String lastName, String id, String address, String phone,
            String comments, Employee employeeCreate) {

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
        Customer customer = new Customer(firstName, lastName, id, address, phone, comments, employeeCreate);

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

    public void addOrders(OrdersDetails[] products, Customer customer, Employee employeeCreate,
            Employee employeeDelivery, LocalDateTime date, String address, String comment) {
        CODE_ORDER++;
        orders.add(new Order(CODE_ORDER, products, customer, employeeCreate, employeeDelivery, date, address, comment));
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
            String type = "PLATO";// Por defecto, no se como agregar al csv

            addProducts(name, ingredients, pricePerSize, availability, type, admin);
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

            addCustomers(firstName, lastName, id, address, phone, comments, admin);
            line = br.readLine();
        }
        br.close();
    }

    public void importEmployee(String fileDirectory) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileDirectory));
        String line = br.readLine();
        while (line != null) {
            String[] parts = line.split(SEPARATE);
            String firstName = parts[0];
            String lastName = parts[1];
            String id = parts[2];
            addEmployees(firstName, lastName, id);
            line = br.readLine();
        }
        br.close();

    }
    // ----------------------------------------------------------------------

    // Change status for orders

    public void setStatus(Order order) {

        if (order.getStatus() != Status.ENTREGADO) {
            int index = (order.getStatus().ordinal() + 1);
            order.setStatus(Status.values()[index]);
        }

    }

    public void generateReportOrders(LocalDateTime dateTimeInit, LocalDateTime dateTimeFinal,String fileDirectory) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(fileDirectory);
        String report = " ";

        Boolean out = true;
        for (int i = 0; i < orders.size() && out; i++) {
            Order order = orders.get(i);
            LocalDateTime date = order.getLocalDateTime();

            if (dateTimeInit.isBefore(date) && date.isBefore(dateTimeFinal)) {
                report += order.toCSV(",");
            }

        }

        pw.println(report);
        pw.close();
        // Aqui se genera el reporte

    }
}
