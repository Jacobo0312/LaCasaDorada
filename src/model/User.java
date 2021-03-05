package model;


public class User extends Employee{

    private String user;
    private String password;
    

    public User(String firstName, String lastName, String id,String user, String password) {
        super(firstName, lastName, id);
        this.user = user;
        this.password = password;
    }


    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPasssword(String passsword) {
        this.password = passsword;
    }

    
}