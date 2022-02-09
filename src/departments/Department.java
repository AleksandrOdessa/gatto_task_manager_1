package departments;

import java.io.Serializable;

public class Department implements Serializable {
    private int id;
    private String nameDepartment;

    public Department(int id, String nameDepartment) {
        this.id = id;
        this.nameDepartment = nameDepartment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", nameDepartment='" + nameDepartment + '\'' +
                '}';
    }
}
