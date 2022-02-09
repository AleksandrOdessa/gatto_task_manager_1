package task;

import users.Roles;
import users.User;

import java.time.LocalDateTime;

public class Task {
    private int id;
    private String title;
    private String discription;
    private LocalDateTime created;
    private User user;
    private User user2;

    public Task(int id, String title, String discription, LocalDateTime created, User user, User user2) {
        this.id = id;
        this.title = title;
        this.discription = discription;
        this.created = created;
        this.user = user;
        this.user2 = user2;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", discription='" + discription + '\'' +
                ", created=" + created +
                ", user=" + user +
                ", user2=" + user2 +
                '}';
    }
}
