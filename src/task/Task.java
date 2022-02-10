package task;

import users.Roles;
import users.User;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Task implements Serializable {
    public static final String PATH = "C:\\Users\\Admin\\Desktop\\Tasks.txt";
    private int id;
    private String title;
    private String discription;
    private LocalDateTime created;



    public Task(int id, String title, String discription, LocalDateTime created) {
        this.id = id;
        this.title = title;
        this.discription = discription;
        this.created = created;

    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }





    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", discription='" + discription + '\'' +
                ", created=" + created + '}';


    }
}
