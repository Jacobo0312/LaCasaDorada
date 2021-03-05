package model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private int code;//Que empiece en 0 y vaya aumentando 
    private Status status;//Enum of status
    private ArrayList<OrdersDetails> products;
    private Customer customer;
    private Employee employeeCreate;
    private Employee employeeModify;
    private Date date;
    private String comment;

    public Order(int code, String status, ArrayList<OrdersDetails> products, int[] amount, Customer customer, Employee employeeCreate,Employee employeeModify, Date date, String comment) {
        this.code = code;
        this.status = Status.valueOf(status);
        this.products = products;
        this.customer = customer;
        this.employeeCreate = employeeCreate;
        this.employeeModify = employeeModify;
        this.date = date;
        this.comment = comment;
    }


}
