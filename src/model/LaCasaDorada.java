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
import java.util.HashMap;
import java.util.Map;

public class LaCasaDorada {

    public static final String SEPARATE = ",";
    public static int CODE_ORDER = 0;// revisar con la serializacion

    private ArrayList<User> users;
    private ArrayList<Product> products;
    private ArrayList<Customer> customers;
    private ArrayList<Order> orders;
    private ArrayList<Employee> employees;
    private ArrayList<Ingredient> ingredients;
    private User admin;

    public LaCasaDorada() {
        users = new ArrayList<User>();
        products = new ArrayList<Product>();
        customers = new ArrayList<Customer>();
        orders = new ArrayList<Order>();
        employees = new ArrayList<Employee>();
        ingredients = new ArrayList<Ingredient>();
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
        // No poder crear con un mismo usuario
    }

    // For verify user

    public User getUser(String name, String password) {
        User user = new User("firstName", "lastNa", "id", name, password);
        int index = Collections.binarySearch(users, user);
        if (index < 0) {
            user = null;
        } else {
            user = users.get(index);
        }
        return user;
    }

    // GET and ADD for Products----------------------------------

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProducts(String name, Ingredient[] ingredients, double[] pricePerSize, Boolean availability,
            String type, Employee employeeCreate) {
        products.add(new Product(name, ingredients, pricePerSize, availability, type, employeeCreate));
    }

    // Get and ADD for Ingredients
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredients(String name, String status) {
        ingredients.add(new Ingredient(name, status));
    }

    private void addIngredients(Ingredient ingredient) {
        ingredients.add(ingredient);
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
            String[] ingredientsString = parts[1].split(" ");
            Ingredient[] ingredientsProduct = new Ingredient[ingredientsString.length];

            for (int i = 0; i < ingredientsProduct.length; i++) {

                Ingredient ingredient = new Ingredient(ingredientsString[i]);

                int index = Collections.binarySearch(ingredients, ingredient);
                if (index > 0) {
                    ingredient = ingredients.get(index);
                }
                addIngredients(ingredient);
                ingredientsProduct[i] = ingredient;

            }
            double[] pricePerSize = { Double.parseDouble(parts[2]), Double.parseDouble(parts[3]) };
            boolean availability = Boolean.parseBoolean(parts[4]);
            String type = "PLATO";// Por defecto, no se como agregar al csv

            addProducts(name, ingredientsProduct, pricePerSize, availability, type, admin);
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

    public void generateReportOrders(LocalDateTime dateTimeInit, LocalDateTime dateTimeFinal, String fileDirectory,
            String separate) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(fileDirectory);
        String report = "nombre" + separate + "direccion" + separate + "telefono" + separate + "Empleado que entrega"
                + separate + "fecha y hora" + separate + "observaciones" + separate + "total" + separate + "\n";

        Boolean out = true;
        for (int i = 0; i < orders.size() && out; i++) {
            Order order = orders.get(i);
            LocalDateTime date = order.getLocalDateTime();

            if (dateTimeInit.isBefore(date) && date.isBefore(dateTimeFinal)) {
                report += order.toCSV(separate) + "\n";
            }

        }

        pw.println(report);
        pw.close();
        // Aqui se genera el reporte

    }

    public void reportEmployeesDelivery(LocalDateTime dateTimeInit, LocalDateTime dateTimeFinal, String absolutePath,
            String separate) throws FileNotFoundException {

        PrintWriter pw = new PrintWriter(absolutePath);
        String report = "REPORTE DE EMPLEADOS \n";

        Map<String, double[]> reportEmployee = new HashMap<String, double[]>();
        Boolean out = true;

        for (int i = 0; i < orders.size() && out; i++) {
            Order order = orders.get(i);
            LocalDateTime date = order.getLocalDateTime();
            // número de pedidos entregados y la suma de los valores de dichos pedidos
            if (dateTimeInit.isBefore(date) && date.isBefore(dateTimeFinal)) {
                Employee employee = order.getEmployeeDelivery();
                double totalOrder = order.getTotal();
                String nameEmployee = employee.getFirstName() + employee.getLastName();
                if (reportEmployee.containsKey(nameEmployee)) {
                    double[] array = reportEmployee.get(nameEmployee);
                    array[0] = array[0]++;
                    array[1] = array[1] + totalOrder;

                    reportEmployee.put(nameEmployee, array);
                } else {
                    double[] array = { 1, totalOrder };
                    reportEmployee.put(nameEmployee, array);
                }

            }

        }
        // Pasar el hash map a reporte

        for (Map.Entry<String, double[]> entry : reportEmployee.entrySet()) {

            report += ("Nombre: " + entry.getKey() + ", Pedidos:" + (int) entry.getValue()[0] + ", Total:"
                    + entry.getValue()[1] + "\n");
        }
        pw.println(report);
        pw.close();
        // Aqui se genera el reporte

    }

    public void reportProducts(LocalDateTime dateTimeInit, LocalDateTime dateTimeFinal, String absolutePath,
            String separate) throws FileNotFoundException {

        PrintWriter pw = new PrintWriter(absolutePath);
        String report = "REPORTE DE PRODUCTOS \n";

        Map<String, double[]> reportProduct = new HashMap<String, double[]>();
        Boolean out = true;

        for (int i = 0; i < orders.size() && out; i++) {
            Order order = orders.get(i);
            LocalDateTime date = order.getLocalDateTime();
            // número de pedidos entregados y la suma de los valores de dichos pedidos
            if (dateTimeInit.isBefore(date) && date.isBefore(dateTimeFinal)) {
                OrdersDetails products [] = order.getProducts();
                for (int j = 0; j < products.length; j++) {
                    double amount = (double) products[j].getAmount();
                    double price = products[j].getPrice();
                    String nameProduct = products[j].getProduct();

                    if (reportProduct.containsKey(nameProduct)) {
                        double[] array = reportProduct.get(nameProduct);
                        amount=array[0]+amount;
                        price=array[1]+price;
                        array[0]= amount;
                        array[1]= price;
                        reportProduct.put(nameProduct,array);
                    } else {
                        double [] array={amount,price};
                        reportProduct.put(nameProduct, array);
                    }
                }

            }

        }
        // Pasar el hash map a reporte

        for (Map.Entry<String,double []> entry : reportProduct.entrySet()) {

            report += ("Nombre: " + entry.getKey() + ", Cantidad pedida:" + (int) entry.getValue()[0] + ", Total:"
                    + entry.getValue()[1] + "\n");
        }
        pw.println(report);
        pw.close();
        // Aqui se genera el reporte

    }

}
