package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Order {
    private int code;//Que empiece en 0 y vaya aumentando 
    private Status status;//Enum of status
    private OrdersDetails[] products;
    private Customer customer;
    private String address;
    private Employee employeeCreate;
    private Employee employeeModify;
    private Employee employeeDelivery;
    private LocalDateTime date;
    private String comment;
    private double total;

    public Order(int code,OrdersDetails[] products,Customer customer, Employee employeeCreate,Employee employeeDelivery, LocalDateTime date,String address, String comment) {
        this.code = code;
        this.status = Status.SOLICITADO;
        this.products = products;
        this.customer = customer;
        this.employeeCreate = employeeCreate;
        this.employeeModify = employeeCreate;
        this.employeeDelivery = employeeDelivery;
        this.date = date;
        this.address = address;
        this.comment = comment;
        this.total=calculateTotal();
    }



    private double calculateTotal() {
        double sum=0;
        for (OrdersDetails ordersDetails : products) {
            sum+=ordersDetails.getPrice();
        }
        return sum;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public OrdersDetails[] getProducts() {
        return this.products;
    }

    public void setProducts(OrdersDetails[] products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public String getDate() {

        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MM/dd/yyyy ' ' hh:mm a");
        String dateString = formatter.format(this.date);
        return dateString ;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    public Employee getEmployeeDelivery() {
        return this.employeeDelivery;
    }

    public void setEmployeeDelivery(Employee employeeDelivery) {
        this.employeeDelivery = employeeDelivery;
    }


    public String toCSV(String separate){
        String message=getCustomer().toString()+separate+getAddress()+separate+getCustomer().getPhone()+separate+getDate()+separate+getComment()+separate+getTotal()+separate;

        for (int i = 0; i < this.products.length; i++) {
            message+=this.products[0].toCSV(separate);
        }

        return message;
    }


}
