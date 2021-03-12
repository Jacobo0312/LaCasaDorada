package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public class Order {
    private int code=0;;//Que empiece en 0 y vaya aumentando 
    private Status status;//Enum of status
    private ArrayList<OrdersDetails> products;
    private Customer customer;
    private Employee employeeCreate;
    private Employee employeeModify;
    private LocalDateTime date;
    private String comment;

    public Order(ArrayList<OrdersDetails> products,Customer customer, Employee employeeCreate, LocalDateTime date, String comment) {
        this.code = code++;
        this.status = Status.REQUESTED;
        this.products = products;
        this.customer = customer;
        this.employeeCreate = employeeCreate;
        this.employeeModify = employeeCreate;
        this.date = date;
        this.comment = comment;
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

    public ArrayList<OrdersDetails> getProducts() {
        return this.products;
    }

    public void setProducts(ArrayList<OrdersDetails> products) {
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


}
