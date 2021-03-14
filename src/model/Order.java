package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public class Order {
    private int code;//Que empiece en 0 y vaya aumentando 
    private Status status;//Enum of status
    private OrdersDetails[] products;
    private Customer customer;
    private String address;
    private Employee employeeCreate;
    private Employee employeeModify;
    private LocalDateTime date;
    private String comment;
    private double total;

    public Order(int code,OrdersDetails[] products,Customer customer, Employee employeeCreate, LocalDateTime date,String address, String comment) {
        this.code = code;
        this.status = Status.REQUESTED;
        this.products = products;
        this.customer = customer;
        this.employeeCreate = employeeCreate;
        this.employeeModify = employeeCreate;
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

    public String getStatus() {
        return this.status.toString();
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

    @Override
    public String toString() {
        return "{" +
            " code='" + getCode() + "'" +
            ", status='" + getStatus() + "'" +
            ", products='" + getProducts().toString() + "'" +
            ", customer='" + getCustomer().getFirstName() + "'" +
            ", address='" + getAddress() + "'" +
            ", employeeCreate='" + getEmployeeCreate() + "'" +
            ", employeeModify='" + getEmployeeModify() + "'" +
            ", date='" + getDate() + "'" +
            ", comment='" + getComment() + "'" +
            ", total='" + getTotal() + "'" +
            "}";
    }



}
