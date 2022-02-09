package users;

import departments.Department;

import java.io.Serializable;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {

     public static String pathListFileAllUsers = "C:\\Users\\Admin\\Desktop\\Users.txt";
    private int id;
    private String name;
    private String lastName;
    private Department department;
    private Roles roles;

    public User(int id, String name, String lastName, Department department, Roles roles) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.department = department;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", roles=" + roles +
                '}';
    }
}

