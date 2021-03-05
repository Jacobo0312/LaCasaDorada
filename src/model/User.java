package model;


public class User extends Employee{

    private String user;
    private String passsword;
    

    public User(String firstName, String lastName, String id,String user, String passsword) {
        super(firstName, lastName, id);
        this.user = user;
        this.passsword = passsword;
    }


    
}