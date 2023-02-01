package lk.ijse.dmi.entity;

public class User {
  private String userID;
  private String name;
  private String password;

    public User() {
    }

    private String role;


    public User(String userID, String name, String password, String role) {
        this.userID = userID;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
