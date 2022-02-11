import departments.Department;
import task.Task;
import users.Roles;
import users.User;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class DoTask {
    Task task;
    public static List<Task> taskList = new ArrayList<>();
    public static List<User> users = new ArrayList<>();


    public static void createdTask() throws InterruptedException {
        handlerScanner();
    }

    public static void startProgram() throws InputMismatchException {
        Scanner sc = startScanner();
        int valueFoeMenu;
        do {
            showMenu();
            valueFoeMenu = sc.nextInt();
            try {
                if (valueFoeMenu != 0 & valueFoeMenu < 7) {

                    switch (valueFoeMenu) {
                        case 1:
                            System.out.println("Create new User or for EXIT input please \"exit\" ");
                            users = createUsers();
                            showAllEmployeeFromList(users);
                            writeUserInFile(users);
                            break;
                        case 2:
                            System.out.println("---------SHOW FILE--------------------");
                            readUserFromFile();
                            showAllEmployeeFromList(users);
                            System.out.println("-----------------------------");
                            break;
                        case 3:
                            System.out.println("---------FOUND & DELETE User------------------");
                            readUserFromFile();
                            foundAndDeleteUserId(users);
                            System.out.println("-----------------------------");
                            break;
                        case 4:
                            System.out.println("---------Create new task------------------");
                            createNewTask();
                            showAllTasks();
                            System.out.println("-----------------------------");
                            break;
                        case 5:
                            System.out.println("---------SHOW ALL task------------------");
                            showAllTasks();
                            System.out.println("-----------------------------");
                            break;
                        case 6:
                            System.out.println("---------WORKFLOW------------------");
                            createWorkflow();
                            System.out.println("-----------------------------");
                            break;
                        case 0:
                            System.out.println("you is exit");
                            break;
                    }
                } else {
                    System.out.println("Something Wrong, repeat input please");
                    startProgram();
                }
            } catch (InputMismatchException | IOException | InterruptedException i) {
                System.out.println("Look what you inputing");
                startProgram();
            }
        } while (valueFoeMenu != 0);
    }

    public static void showAllTasks() throws FileNotFoundException {
        try (FileInputStream stream = new FileInputStream(Task.PATH);
             ObjectInputStream obj = new ObjectInputStream(stream)) {
            taskList = (List<Task>) obj.readObject();
            for (Task t : taskList) {
                System.out.println(t);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static synchronized void createNewTask() {

        Scanner sc = startScanner();
        System.out.println("How many you nedd tasks");
        int countTasks = sc.nextInt();
        for (int i = 0; i < countTasks; i++) {
            Task task = new Task();
            Scanner sc2 = startScanner();
            System.out.print("Input number of task: ");
            task.setId(Integer.parseInt(sc2.nextLine()));
            System.out.print("Input title: ");
            task.setTitle(sc2.nextLine());
            System.out.print("Input Description: ");
            task.setDiscription(sc2.nextLine());
            task.setCreated(LocalDateTime.now());

            taskList.add(task);
        }
        writeTaskForFile(taskList);
    }

    public static void writeTaskForFile(List<Task> t) {
        try (ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(Task.PATH))) {
            obj.writeObject(t);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static synchronized void foundAndDeleteUserId(List<User> users) throws IOException {
        Scanner sc = startScanner();
        boolean search = false;//Вот тут не понял
        int foundId = sc.nextInt();
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User u = iterator.next();
            if (u.getId() == foundId) {
                System.out.println(u);
                iterator.remove();
                System.out.println("User with ID = " + foundId + " DELETED!");
                search = true;
                ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(User.pathListFileAllUsers));
                obj.writeObject(users);
                obj.close();
            }
        }
        if (!search) {  ////Вот тут не понял
            System.out.println("NOT FOUND");
        }
    }


    public static void showAllEmployeeFromList(List<User> users) {
        for (User u : users) {
            System.out.println(u);
        }
    }


    public static synchronized void readUserFromFile() throws FileNotFoundException {
        try (FileInputStream stream = new FileInputStream(User.pathListFileAllUsers);
             ObjectInputStream obj = new ObjectInputStream(stream)) {
            users = (List<User>) obj.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static synchronized void writeUserInFile(List<User> users) throws IOException {
        try (FileOutputStream stream = new FileOutputStream(User.pathListFileAllUsers);
             ObjectOutputStream obj = new ObjectOutputStream(stream)) {
            obj.writeObject(users);

        } catch (FileNotFoundException f) {
            System.out.println("Check your path");
            writeUserInFile(users);
        }


    }


    public static synchronized List<User> createUsers() throws IOException {

        Scanner reader = startScanner();
        System.out.print("How many you need have created users: ");
        int count = reader.nextInt();
        Scanner reader2 = startScanner();
        for (int i = count; i >= 1; i--) {
            try {
                User user = new User();
                System.out.print("Input ID: ");
                user.setId(Integer.parseInt(reader2.nextLine()));
                System.out.print("Input name: ");
                user.setName(reader2.nextLine());
                System.out.print("Input LastName: ");
                user.setLastName(reader2.nextLine());
                System.out.print("Input Department: ");
                Department department = createDepartment(reader2);
                user.setDepartment(department);
                System.out.print("Choose Role. M - manager, E - employee: ");
                chooseRole(reader2.nextLine(), user);

                users.add(user);

            } catch (NumberFormatException n) {
                createUsers();
            }
        }
        return users;
    }

    public static Department createDepartment(Scanner sc) throws IOException {
        Department department = new Department();
        try {
            System.out.print("Input ID of Department: ");
            department.setId(Integer.parseInt(sc.nextLine()));
            System.out.print("Input Name of Department: ");
            department.setNameDepartment(sc.nextLine());
        } catch (NumberFormatException n) {
            createDepartment(sc);
        }
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
        System.out.println("Read all employees, input 2");
        System.out.println(" Found and Delete employees, input 3");

        System.out.println("Appoint new task, input 4");
        System.out.println("Reading all tasks, input 5");
        System.out.println("Create workflow, input 6");
        System.out.println("For EXIT, input 0");
        System.out.println("---------------------------");
    }

    public static void createWorkflow() throws IOException, InterruptedException {
        readUserFromFile();
        Map<User, Task> bundle = new HashMap<>();
        if (users.isEmpty()) {
            createUsers();
        }
        if (taskList.isEmpty()) {
            createdTask();
        }
        showAllTasks();
        showAllEmployeeFromList(users);
        System.out.println("***********************");
        System.out.println("Input ID User");
        User user = foundUsers();
        System.out.println("Input ID Task");
        Task task = foundTask();
        bundle.put(user, task);
        System.out.println(bundle);

    }

    public static User foundUsers() throws IOException {
        User user=null;
        Scanner sc = startScanner();
        int valueID = sc.nextInt();
        if(!users.isEmpty()){
            System.out.println(valueID);
            for (User u : users) {
                if (valueID == u.getId()) {
                    user = u;
                }
                if(valueID!= u.getId()){
                    System.out.println("\"NOT FOUND USER!!!!. Input please againe\"");
                    foundUsers();
                }
            }
        }if(users.isEmpty()){
            createUsers();
        }

        return user;
    }

    public static Task foundTask() throws InterruptedException {
        Task task=null;
        Scanner sc = startScanner();
        int valueID = sc.nextInt();
        if(!taskList.isEmpty()){
            for (Task t : taskList) {
                if (valueID == t.getId()) {
                    task = t;
                }
                if(valueID!= t.getId()){
                    System.out.println("\"NOT FOUND USER!!!!. Input please againe\"");
                    foundTask();
                }
            }
        }if(taskList.isEmpty()){
            createdTask();
        }

        return task;
    }


    public static Scanner startScanner() {
        Scanner sc = new Scanner(System.in);
        return sc;
    }
}