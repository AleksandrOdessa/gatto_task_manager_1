import departments.Department;
import task.Task;
import users.Roles;
import users.User;

import java.io.*;
import java.util.*;

public class DoTask {
    Task task;
    public static List<Task> taskList = new ArrayList<>();
    public static List<User> users = new ArrayList<>();


    public static void createdTask() throws InterruptedException {
        showMenu();
        Thread.sleep(2000);
        handlerScanner();


    }


    public static void startProgram() throws InputMismatchException {
        Scanner sc = startScanner();

        int valueFoeMenu = sc.nextInt();
        try {
            if (valueFoeMenu != 0 & valueFoeMenu < 4) {
                switch (valueFoeMenu) {
                    case 1:
                        System.out.println("Create new User or for EXIT input please \"exit\" ");
                        User user = createUser();
                        writeUserInFile(user);
                        break;
                    case 2:

                        System.out.println("In progress");
//                        addUserForList(user);
                        break;
                    case 3:
                        System.out.println("In progress");
                        break;
                    case 0:
                        System.out.println("you is exit");
                        break;
                }

            } else {
                System.out.println("Something Wrong, repeat input please");
                startProgram();
            }
        } catch (InputMismatchException | IOException i) {
            System.out.println("Look what you inputing");
            startProgram();
        }


    }

    public static synchronized void readUserFromFile() throws FileNotFoundException {
        try (FileInputStream stream = new FileInputStream(User.pathListFileAllUsers);
             ObjectInputStream obj = new ObjectInputStream(stream)) {
            User user = (User) obj.readObject();
            System.out.println(user);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static synchronized void writeUserInFile(User user) throws IOException {
        try (FileOutputStream steram = new FileOutputStream(User.pathListFileAllUsers);
             ObjectOutputStream obj = new ObjectOutputStream(steram)) {
            obj.writeObject(user);

        } catch (FileNotFoundException f) {
            System.out.println("Check your path");
            writeUserInFile(user);
        }


    }

    public static synchronized void addUserForList(User user) {
        users.add(user);

    }

    public static synchronized User createUser() throws IOException {
        User user = new User();
        Scanner reader = startScanner();
        System.out.println("Input ID");
        user.setId(Integer.parseInt(reader.nextLine()));
        System.out.println("Input name");
        user.setName(reader.nextLine());
        System.out.println("Input LastName");
        user.setLastName(reader.nextLine());
        System.out.println("Input Department");
        Department department = createDepartment(reader);
        user.setDepartment(department);
        System.out.println("Choose Role. M - manager, E - employee");
        chooseRole(reader.nextLine(), user);

        return user;
    }

    public static Department createDepartment(Scanner sc) throws IOException {
        Department department = new Department();
        System.out.println("Input ID of Department");
        department.setId(Integer.parseInt(sc.nextLine()));
        System.out.println("Input Name of Department");
        department.setNameDepartment(sc.nextLine());

        return department;

    }

    public static void chooseRole(String s, User user) {
        if (s.equals("M")) {
            user.setRoles(Roles.MANAGER);
        } else if (s.equals("E")) {
            user.setRoles(Roles.EMPLOYEE);
        } else {
            System.out.println("You wrong");
        }
    }

    public static void handlerScanner() {

        System.out.println("HI");
        startProgram();

    }


    public static void showMenu() {
        System.out.println("CHOOSE what you want to do");
        System.out.println("---------------------------");
        System.out.println("Add new employee, input 1");
        System.out.println("Show all employees, input 2");
        System.out.println("Appoint new task, input 3");
        System.out.println("Check their tasks, input 4");
        System.out.println("For EXIT, input 0");
        System.out.println("---------------------------");
    }

    public static Scanner startScanner() {
        Scanner sc = new Scanner(System.in);

        return sc;
    }
}