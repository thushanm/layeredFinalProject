package lk.ijse.dmi.dto;

public class UserDTO {
    private String id;
    private String name;
    private String pwd;
    private String role;


    public UserDTO(String id, String name, String pwd, String role) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.role = role;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
