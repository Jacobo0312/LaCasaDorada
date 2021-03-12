package model;

import java.time.LocalDateTime;
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


}
