package model;


public class User extends Employee implements Comparable<User>{

    private static final long serialVersionUID = 1L;
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

    public void setPassword(String passsword) {
        this.password = passsword;
    }



    @Override
    public int compareTo(User obj1) {
        String user = obj1.getUser();
        String password=obj1.getPassword();

        if (this.user.compareTo(user) == 0) {

            return this.password.compareTo(password);
        } else {
            return this.user.compareTo(user);
        }
    }


    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
            User obj = (User) o;
        return obj.getUser().equals(this.user);
    }






}