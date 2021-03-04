package model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private String code;//Autogenerado
    private Status status;//Enum of status
    private ArrayList<Product> products;
    private int[] amount; //Amound of products
    private Customer customer;
    private Employee employee;
    private Date date;
    private String Comment;

    public Order(String code, Status status, ArrayList<Product> products, int[] amount, Customer customer, Employee employee, Date date, String Comment) {
        this.code = code;
        this.status = status;
        this.products = products;
        this.amount = amount;
        this.customer = customer;
        this.employee = employee;
        this.date = date;
        this.Comment = Comment;
    }


}
