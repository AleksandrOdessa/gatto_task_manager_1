import users.User;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DoTask.createdTask();
        for (User u : DoTask.users) {
            System.out.println(u);
        }
        try {
            System.out.println("************");
            DoTask.readUserFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
