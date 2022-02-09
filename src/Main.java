import users.User;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DoTask.createdTask();
        try {
            DoTask.readUserFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
